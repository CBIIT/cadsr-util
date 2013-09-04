/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

import java.util.List;

public interface ValueDomainV2 extends ValueDomain
{
   public List getPermissibleValueV2();
   public void setPermissibleValueV2(List permissibleValuesV2);
 
}