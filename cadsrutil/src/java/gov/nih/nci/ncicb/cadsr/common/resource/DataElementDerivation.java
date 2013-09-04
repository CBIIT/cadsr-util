/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;
import java.util.Collection;

public interface DataElementDerivation extends Audit
{
   public DataElement getDerivedDataElement();
   public void setDerivedDataElement(DataElement de);

   public int getDisplayOrder();
   public void setDisplayOrder(int displayOrder);

}