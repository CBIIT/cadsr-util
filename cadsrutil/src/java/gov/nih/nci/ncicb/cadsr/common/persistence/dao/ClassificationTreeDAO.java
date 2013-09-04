/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;
import java.util.Collection;

public interface ClassificationTreeDAO 
{
 
 public Collection getAllCSIHeirarchies(String csidseq);
  
}