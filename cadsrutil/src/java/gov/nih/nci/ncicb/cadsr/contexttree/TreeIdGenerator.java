/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.contexttree;

public class TreeIdGenerator 
{
  private long id = 0;
  public TreeIdGenerator()
  {
  }
  public TreeIdGenerator(long initialVal)
  {
    id = initialVal;
  }  
  public String getNewId()
  {
    id++;
    return String.valueOf(id);
  }
}