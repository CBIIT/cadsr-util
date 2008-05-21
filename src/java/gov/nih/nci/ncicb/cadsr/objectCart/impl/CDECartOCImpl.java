package gov.nih.nci.ncicb.cadsr.objectCart.impl;

import gov.nih.nci.ncicb.cadsr.objectCart.CDECart;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECartItem;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECartItemComparator;
import gov.nih.nci.ncicb.cadsr.objectCart.CartObjectItemComparator;
import gov.nih.nci.objectCart.client.CartManager;
import gov.nih.nci.objectCart.client.ObjectCartClient;
import gov.nih.nci.objectCart.client.ObjectCartException;
import gov.nih.nci.objectCart.domain.Cart;
import gov.nih.nci.objectCart.domain.CartObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CDECartOCImpl implements CDECart, Serializable  {

	private Cart oCart;
	private CDECartItemComparator itemComparator;
	private CartManager cm;
	private String CLASSIFICATION_SCHEME;
	private String userId;
	private String cartName;

	public CDECartOCImpl(CartManager cManager, String uid, String cName, String scheme) {
		oCart = new Cart();
		itemComparator = new CDECartItemComparator();
		cm = cManager;
		CLASSIFICATION_SCHEME = scheme;
		userId = uid;
		cartName = cName;
		try {
			oCart = cm.getClient(CLASSIFICATION_SCHEME).createCart(userId, cartName);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("Constructor: Error creating the Object Cart with Classification Scheme: "+scheme, oce);
		}
	}  
	
	public Collection getDataElements() {

		try {
			Collection items = cm.getClient(CLASSIFICATION_SCHEME).getPOJOCollection(CDECartItemImpl.class, oCart.getCartObjectCollection());
			List itemList = new ArrayList(items);
			Collections.sort(itemList,itemComparator);
			return itemList;
		} catch (ObjectCartException oce) {
			oce.printStackTrace();
			throw new RuntimeException("getDataElements: Error restoring the POJO Collection", oce);
		}

	}

	public void setDataElement(CDECartItem item) {
		CartObject co = this.getNativeObject(item.getId());
		if (co == null){
			try {
				oCart = cm.getClient(CLASSIFICATION_SCHEME).storePOJO(oCart, CDECartItem.class, item.getItem().getLongName(), item.getId(), item);
			} catch (ObjectCartException oce) {
				throw new RuntimeException("getDataElements: Error restoring the POJO Collection", oce);
			}
		}
	}

	public void setDataElements(Collection items) {
		Map<String, String> objectDisplayNames = new HashMap<String, String> ();
		Map<String, Object>  objects = new HashMap<String, Object>();

		for(Object o: items) {
			CDECartItem item = (CDECartItem) o;
			objectDisplayNames.put(item.getId(), item.getItem().getLongName());
			objects.put(item.getId(), item);
		}
		try {
			oCart = cm.getClient(CLASSIFICATION_SCHEME).storePOJOCollection(oCart, CDECartItemImpl.class, objectDisplayNames, objects);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("getDataElements: Error restoring the POJO Collection", oce);
		}
	}

	public Collection getForms() {
		try {
			return cm.getClient(CLASSIFICATION_SCHEME).getPOJOCollection(CDECartItemImpl.class, oCart.getCartObjectCollection());
		} catch (ObjectCartException oce) {
			throw new RuntimeException("getForms: Error restoring the POJO Collection", oce);
		}
	}

	public void setForm(CDECartItem form) {
		try {
			if (getId(oCart, form.getId()) != null)
				oCart = cm.getClient(CLASSIFICATION_SCHEME).storePOJO(oCart, form.getClass(), form.getItem().getLongName(), form.getId(), form);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("getForms: Error storing the POJO Collection", oce);
		}
	}

	public void setForms(Collection forms) {
		Map<String, String> objectDisplayNames = new HashMap<String, String> ();
		Map<String, Object>  objects = new HashMap<String, Object>();

		for(Object o: forms) {
			CDECartItem item = (CDECartItem) o;
			objectDisplayNames.put(item.getId(), item.getItem().getLongName());
			objects.put(item.getId(), item);
		}
		try {
			oCart = cm.getClient(CLASSIFICATION_SCHEME).storePOJOCollection(oCart, CDECartItemImpl.class, objectDisplayNames, objects);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("getDataElements: Error restoring the POJO Collection", oce);
		}
	}

	public void mergeCart(CDECart cart) {
		//TODO: Check if this can be done better since we have Clients 
		//and option to merge within ObjectCartService
		Collection deColl = cart.getDataElements();
		setDataElements(deColl);
		//Collection formColl = cart.getForms();
		//setForms(formColl);
	}

	public void removeDataElement(String itemId) {
		CartObject co = getNativeObject(itemId);
		if (co != null) {
			try {	
				oCart = cm.getClient(CLASSIFICATION_SCHEME).removeObject(oCart, co);			
			} catch (ObjectCartException oce) {
				throw new RuntimeException("removeDataElement: Error removing object with native ID:"+itemId, oce);
			}			
		}		
	}

	public void removeDataElements(Collection items) {
		List<CartObject> cList = getNativeObjects(items);
		if (!cList.isEmpty()) {
			try {	
				oCart = cm.getClient(CLASSIFICATION_SCHEME).removeObjectCollection(oCart, cList);
			} catch (ObjectCartException oce) {
				throw new RuntimeException("removeDataElements: Error removing collection of objects", oce);
			}	
		}
	}

	public CDECartItem findDataElement(String itemId) {
		CartObject item = getId(oCart, itemId);
		if ( item != null) {
			try {
				return (CDECartItem)cm.getClient(CLASSIFICATION_SCHEME).getPOJO(CDECartItem.class, item);
			} catch (ObjectCartException oce) {
				throw new RuntimeException("findDataElement: Error finding objects with native Id:"+itemId, oce);
			}
		}

		return null; 
	}

	private CartObject getNativeObject(String id) {
		for(CartObject co: oCart.getCartObjectCollection()){
			if (co.getNativeId().equals(id))
				return co;
		}
		return null;
	}

	private List<CartObject> getNativeObjects(Collection ids) {
		List<CartObject> list = new ArrayList<CartObject>();
		for(CartObject co: oCart.getCartObjectCollection()){
			if (ids.contains(co.getNativeId()))
				list.add(co);
		}
		return list;
	}

	private CartObject getId(Cart cart, String id) {
		for(CartObject co: cart.getCartObjectCollection()){
			if (co.getNativeId().equals(id))
				return co;
		}
		return null;
	}

	public void associatCart(String userId) {	
		try {
			 oCart = cm.getClient(CLASSIFICATION_SCHEME).associateCart(oCart, userId);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("associateCart: Error associating cart ("+oCart.getUserId()+") with new User ID "+userId, oce);
		}
	}
	
}
