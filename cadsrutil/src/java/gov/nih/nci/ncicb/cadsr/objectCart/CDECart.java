/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.objectCart;

import gov.nih.nci.ncicb.cadsr.common.resource.Form;

import java.util.Collection;
import java.util.Date;

public interface CDECart  {
  public Collection getDataElements();
  public void setDataElements(Collection items);
  public void setDataElement(CDECartItem item);

  public Collection getForms();
  public void setForm(CDECartItem form);
  public void setForms(Collection forms);

  public void removeDataElement(String itemId);
  public void removeDataElements(Collection items);

  public CDECartItem findDataElement(String itemId);
  public Object findElement(String itemId, Class objectType);

  public void mergeCart(CDECart cart);
  public void mergeDataElements(Collection items);
  public void mergeElements(Collection items);
  
  public void associateCart(String userId);
  
  public void expireCart();
  public void expireCart(Date expireDate);
  public String getCartName();
  public String getCartId();
  
  public void addForm(Object form);
  public void addForms(Collection forms);
  public void mergeFormCart();
}