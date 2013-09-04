/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;
import gov.nih.nci.ncicb.cadsr.common.exception.DMLException;
import java.util.Locale;
import java.util.Properties;

public interface UtilDAO 
{
    /**
   * Utility method to get the Application properties
   *
   * @param <b>Application Name<b> corresponds to the target record whose 
   *        display order is to be updated
   * @param <b>Locale<b> of the user
   *
   * @return <b>properties</b> containing application properties
   *
   * @throws <b>DMLException</b>
   */
    public Properties getApplicationProperties(String ApplicationName, String locale) throws DMLException;

    /**
     * Utility method to get the Application properties
     *
     * @param <b>Application Name<b> corresponds to the target record whose 
     *        display order is to be updated
     * @param <b>Locale<b> of the user
     * @param <b>property<b> specific property to search for
     *
     * @return <b>properties</b> containing application properties
     *
     * @throws <b>DMLException</b>
     */
      public Properties getApplicationURLProperties(String locale) throws DMLException;

}