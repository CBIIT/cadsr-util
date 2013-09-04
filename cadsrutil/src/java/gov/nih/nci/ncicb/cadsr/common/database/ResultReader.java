/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.database;

import java.util.List;


/**
 * Extension of RowCallbackHandler that saves the
 * accumulated results as a Collection.
 */
public interface ResultReader extends RowCallbackHandler {
	 
	/**
	 * Return all results, disconnected from the JDBC ResultSet.
	 * @return all results, disconnected from the JDBC ResultSet.
	 * Never returns null; returns the empty collection if there
	 * were no results.
	 */
	List getResults();

}
