package gov.nih.nci.ncicb.cadsr.objectCart.impl;

import gov.nih.nci.cadsr.domain.Form;
import gov.nih.nci.ncicb.cadsr.common.dto.FormTransferObject;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECart;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECartItem;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECartItemComparator;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECartItemTransferObject;
import gov.nih.nci.objectCart.client.ObjectCartClient;
import gov.nih.nci.objectCart.client.ObjectCartException;
import gov.nih.nci.objectCart.domain.Cart;
import gov.nih.nci.objectCart.domain.CartObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CDECartOCImpl implements CDECart, Serializable  {

	private Cart oCart;
	private CDECartItemComparator itemComparator;
	private ObjectCartClient cartClient;
	private String userId;
	private String cartName;
	private Class CDECartObjectType;
	
	public static ArrayList<CDECart> getAllCarts(ObjectCartClient client, String uid) {
		ArrayList<CDECart> ret = new ArrayList<CDECart>();
		try {
			List<Cart> carts = client.retrieveUserCarts(uid);
			for (Cart c: carts) {
				CDECart retCart = new CDECartOCImpl(client, uid, c.getName());
				ret.add(retCart);
			}
		} catch (ObjectCartException oce) {
			throw new RuntimeException("Constructor: Error creating the Object Cart ", oce);
		}
		
		return ret;
	}
	
	public CDECartOCImpl(ObjectCartClient client, String uid, String cName) {
		oCart = new Cart();
		itemComparator = new CDECartItemComparator();
		userId = uid;
		cartName = cName;
		cartClient = client;
		CDECartObjectType = CDECartItemTransferObject.class;
		
		try {
			oCart = cartClient.createCart(userId, cartName);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("Constructor: Error creating the Object Cart ", oce);
		}
	}  
	
	public Collection getDataElements() {
		return getElements(CDECartItemTransferObject.class);
	}	

	public Collection getForms() {
		return getElements(FormTransferObject.class);
	}

	private Collection getElements(Class type) {
		try {
			Collection cartElements = cartClient.getObjectsByType(oCart, type);
			if (cartElements != null){
				Collection items = ObjectCartClient.getPOJOCollection(type, cartElements);
				List itemList = new ArrayList(items);
				Collections.sort(itemList,getComparator(type));
				return itemList;
			} else 
				return new ArrayList();
		} catch (ObjectCartException oce) {
			oce.printStackTrace();
			throw new RuntimeException("getElements: Error restoring the POJO Collection", oce);
		}
	}
	
	private Comparator getComparator(Class type) {
		if (type.getName().equalsIgnoreCase("CDECartItemTransferObject")) {
			return itemComparator;
		}
		else if (type.getName().equalsIgnoreCase("FormTransferObject")) {
			return new Comparator() {
				public int compare(Object o1, Object o2) {
					Form form1 = (Form)o1;
					Form form2 = (Form)o2;
					return form1.getLongName().compareToIgnoreCase(form2.getLongName());
				}
			};
		}
		else {
			return new Comparator() {	
				public int compare(Object o1, Object o2) {
					return 0;
				}
			};
		}
	}
	
	public void setDataElement(CDECartItem item) {
		setElement(item);
	}
	
	public void setForm(CDECartItem form) {
		setElement(form);
	}
	
	private void setElement(CDECartItem item) {
		CartObject co = this.getNativeObject(item.getId());
		if (co == null){
			try {
				oCart = cartClient.storePOJO(oCart, CDECartItem.class, item.getItem().getLongName(), item.getId(), item);
			} catch (ObjectCartException oce) {
				throw new RuntimeException("getDataElements: Error storing the POJO ", oce);
			}
		}
	}
	
	public void setDataElements(Collection items) {
		setElements(items);
	}
	
	public void setForms(Collection forms) {
		setElements(forms);
	}
	
	
	private void setElements(Collection items) {
	
		Map<String, String> objectDisplayNames = new HashMap<String, String> ();
		Map<String, Object>  objects = new HashMap<String, Object>();

		for(Object o: items) {
			CDECartItem item = (CDECartItem) o;
			if(getNativeObject(item.getId()) == null){
				objectDisplayNames.put(item.getId(), item.getItem().getLongName());
				objects.put(item.getId(), item);
			}			
		}
		try {
			oCart = cartClient.storePOJOCollection(oCart, CDECartObjectType, objectDisplayNames, objects);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("getDataElements: Error restoring the POJO Collection", oce);
		}
	}	

	public void mergeCart(CDECart cart) {			
		Collection deColl = cart.getDataElements();						
		mergeDataElements(deColl);	    
	}
	
	public void mergeDataElements(Collection items) {
		Map<String, String> objectDisplayNames = new HashMap<String, String> ();
		Map<String, Object>  objects = new HashMap<String, Object>();
		HashSet<CartObject> forRemoval = new HashSet<CartObject>();
		
		for(Object o: items) {
			CDECartItem item = (CDECartItem) o;
			CartObject co = getNativeObject(item.getId());
			
			objectDisplayNames.put(item.getId(), item.getItem().getLongName());
			objects.put(item.getId(), item);
			
			if(co != null)
				forRemoval.add(co);
		}
		try {
			oCart = cartClient.removeObjectCollection(oCart, forRemoval);
			oCart = cartClient.storePOJOCollection(oCart, CDECartObjectType, objectDisplayNames, objects);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("getDataElements: Error restoring the POJO Collection", oce);
		}
	}
	
	public void mergeElements(Collection items) {
		Map<String, String> objectDisplayNames = new HashMap<String, String> ();
		Map<String, Object>  objects = new HashMap<String, Object>();
		HashSet<CartObject> forRemoval = new HashSet<CartObject>();
		
		for(Object o: items) {
			FormTransferObject item = (FormTransferObject) o;
			CartObject co = getNativeObject(item.getIdseq());
			
			objectDisplayNames.put(item.getIdseq(), item.getLongName());
			objects.put(item.getIdseq(), item);
			
			if(co != null)
				forRemoval.add(co);
		}
		try {
			oCart = cartClient.removeObjectCollection(oCart, forRemoval);
			oCart = cartClient.storePOJOCollection(oCart, FormTransferObject.class, objectDisplayNames, objects);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("mergeElements: Error restoring the POJO Collection", oce);
		}
	}
	
	
	public void removeDataElement(String itemId) {
		CartObject co = getNativeObject(itemId);
		if (co != null) {
			try {	
				oCart = cartClient.removeObject(oCart, co);			
			} catch (ObjectCartException oce) {
				throw new RuntimeException("removeDataElement: Error removing object with native ID:"+itemId, oce);
			}			
		}		
	}

	public void removeDataElements(Collection items) {
		List<CartObject> cList = getNativeObjects(items);
		if (!cList.isEmpty()) {
			try {	
				oCart = cartClient.removeObjectCollection(oCart, cList);
			} catch (ObjectCartException oce) {
				throw new RuntimeException("removeDataElements: Error removing collection of objects", oce);
			}	
		}
	}

	public CDECartItem findDataElement(String itemId) {
		CartObject item = getId(oCart, itemId);
		if ( item != null) {
			try {
				return (CDECartItem)cartClient.getPOJO(CDECartObjectType, item);
			} catch (ObjectCartException oce) {
				throw new RuntimeException("findDataElement: Error finding objects with native Id:"+itemId, oce);
			}
		}

		return null; 
	}
	
	public Object findElement(String itemId, Class objectType) {
		CartObject item = getId(oCart, itemId);
		if ( item != null) {
			try {
				return cartClient.getPOJO(objectType, item);
			} catch (ObjectCartException oce) {
				throw new RuntimeException("findDataElement: Error finding objects with native Id:"+itemId, oce);
			}
		}

		return null; 
	}

	private CartObject getNativeObject(String id) {
		if (oCart.getCartObjectCollection() == null)
			return null;
		
		for(CartObject co: oCart.getCartObjectCollection()){
			if (co.getNativeId().equals(id))
				return co;
		}
		return null;
	}
	
	private List<CartObject> getNativeObjects(Collection ids) {
		List<CartObject> list = new ArrayList<CartObject>();
		if (oCart.getCartObjectCollection() == null)
			return list;
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

	public void associateCart(String userId) {	
		try {			
			 oCart = cartClient.associateCart(oCart, userId);
		} catch (ObjectCartException oce) {
			throw new RuntimeException("associateCart: Error associating cart ("+oCart.getUserId()+") with new User ID "+userId, oce);
		}		
	}

	public void expireCart(){
		try{
			oCart = cartClient.setDefaultExpiration(oCart);
		}catch(ObjectCartException oce){
			throw new RuntimeException("expireCart: Error in setting Cart for default Expiration("+oCart.getUserId()+")");
		}		
	}
	
	public void expireCart(Date expirationDate){
		try{
			oCart = cartClient.setCartExpiration(oCart, expirationDate);
		}catch(ObjectCartException oce){
			throw new RuntimeException("expireCart: Error in setting Cart Expiration by date("+oCart.getUserId()+")");
		}		
	}
	
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the cartName
	 */
	public String getCartName() {
		return cartName;
	}

	/**
	 * @param cartName the cartName to set
	 */
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}	
	
	public String getCartId() {
		return oCart.getId().toString();	
	}
}
