/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.objectCart.impl;

import gov.nih.nci.ncicb.cadsr.objectCart.CDECart;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECartItem;
import gov.nih.nci.ncicb.cadsr.objectCart.CDECartItemComparator;
import gov.nih.nci.objectCart.domain.CartObject;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CDECartImpl implements CDECart, Serializable  {
  private Map deCart;
  private Map formCart;
  private CDECartItemComparator itemComparator;
  public CDECartImpl() {
    deCart = new HashMap();
    formCart = new HashMap();
    itemComparator = new CDECartItemComparator ();
  }

  public Collection getDataElements() {
    Collection items = deCart.values();
    List itemList = new ArrayList(items);
    Collections.sort(itemList,itemComparator);
    return itemList;
  }

  public void setDataElements(Collection items) {
    Iterator itemIter = items.iterator();
    while (itemIter.hasNext()) {
      setDataElement((CDECartItem)itemIter.next());
    }
  }

  public void setDataElement(CDECartItem item) {
    if (!deCart.containsKey(item.getId()))
      deCart.put(item.getId(), item);
  }

  public Collection getForms() {
    return formCart.values();
  }

  public void setForm(CDECartItem form) {
    if (!formCart.containsKey(form.getId()))
      formCart.put(form.getId(), form);
  }

  public void setForms(Collection forms) {
    Iterator itemIter = forms.iterator();
    while (itemIter.hasNext()) {
      setForm((CDECartItem)itemIter.next());
    }
  }

  public void mergeCart(CDECart cart) {
    Collection deColl = cart.getDataElements();
    setDataElements(deColl);
    //Collection formColl = cart.getForms();
    //setForms(formColl);
  }

  public void removeDataElement(String itemId) {
    deCart.remove(itemId);
  }

  public void removeDataElements(Collection items) {
    Iterator itemIter = items.iterator();
    while (itemIter.hasNext()) {
      removeDataElement((String)itemIter.next());
    }
  }

  public CDECartItem findDataElement(String itemId) {
    CDECartItem item = null;
    if (deCart.containsKey(itemId))
      item = (CDECartItem)deCart.get(itemId);
    return item; 
  }
  
  public void associateCart(String userId){
	  //TODO
  }
  
  public void mergeDataElements(Collection c){
	  //TODO
  }
  
  public void expireCart(){
	//TODO  
  }
  
  public void expireCart(Date expireDate){
	  //TODO
  }

public String getCartId() {
	// TODO Auto-generated method stub
	return null;
}

public String getCartName() {
	// TODO Auto-generated method stub
	return null;
}

public Object findElement(String itemId, Class objectType) {
	// TODO Auto-generated method stub
	return null;
}

public void mergeElements(Collection items) {
	// TODO Auto-generated method stub
	
}

public void addForm(Object form) {
	// TODO Auto-generated method stub
	
}

public void addForms(Collection forms) {
	// TODO Auto-generated method stub
	
}

public void mergeFormCart() {
	// TODO Auto-generated method stub
	
}

public void addFormV2(Object form) {
	// TODO Auto-generated method stub
	
}
}