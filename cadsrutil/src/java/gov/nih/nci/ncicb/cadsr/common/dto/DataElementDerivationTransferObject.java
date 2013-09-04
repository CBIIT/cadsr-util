/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.dto;

import gov.nih.nci.ncicb.cadsr.common.resource.DataElement;
import gov.nih.nci.ncicb.cadsr.common.resource.DataElementDerivationType;
import gov.nih.nci.ncicb.cadsr.common.resource.DerivedDataElement;
import gov.nih.nci.ncicb.cadsr.common.resource.DataElementDerivation;
import gov.nih.nci.ncicb.cadsr.common.util.DebugStringBuffer;
import java.util.Collection;



public class DataElementDerivationTransferObject extends BaseTransferObject
  implements DataElementDerivation{
  private String cdrIdSeq;
  private int displayOrder;
  private DataElement derivedDataElement ;

  public DataElementDerivationTransferObject() {
  }


  public boolean equals(Object obj)
  {/*
   if(obj == null)
    return false;
   if(!(obj instanceof DerivedDataElement))
    return false;
   DerivedDataElement derivedDataElement = (DerivedDataElement)obj;
   if(derivedDataElement.getDdeIdseq().equals(this.getDdeIdSeq()))
   {
     return true;
   }*/
   return false;
 }
  public String toString() {
   return "";
  }


   public void setDisplayOrder(int displayOrder) {
      this.displayOrder = displayOrder;
   }


   public int getDisplayOrder() {
      return displayOrder;
   }


   public void setDerivedDataElement(DataElement derivedDataElement) {
      this.derivedDataElement = derivedDataElement;
   }


   public DataElement getDerivedDataElement() {
      return derivedDataElement;
   }


   public void setCdrIdSeq(String cdrIdSeq) {
      this.cdrIdSeq = cdrIdSeq;
   }


   public String getCdrIdSeq() {
      return cdrIdSeq;
   }



}
