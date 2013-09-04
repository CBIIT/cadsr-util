/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.persistence.dao;

import gov.nih.nci.ncicb.cadsr.common.resource.ValidValue;

import java.util.Collection;
import java.util.Map;

public interface DataElementDAO {

	public Map<String, ValidValue> getPermissibleValues(Collection<String> deIdSeqs);
	public boolean isDEDerived(String deIdSeq);
}
