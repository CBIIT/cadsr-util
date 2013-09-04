/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.exception;

public interface HasRootCause {
	
	/** 
	 * Return the root cause of this exception
	 * @return the root cause of this exception,
	 * or null if there was no root cause
	 */
	Throwable getRootCause();

}