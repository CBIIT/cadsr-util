/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.resource;

public enum ComponentType {
	
	CDE,
	DEC,
	VD,
	OC,
	PROP,
	CONCEPT,
	REPRESENTATION,
	CONCEPTUAL_DOMAIN,
	CS,
	CSI,
	FORMELEMENT,
	UNKNOWN;
	
	public static ComponentType getComponentType(String _value) {
		if (_value.equalsIgnoreCase("QUEST_CONTENT")) {
			return FORMELEMENT;
		} 
		else if (_value.equalsIgnoreCase("DATAELEMENT")) {
			return CDE;
		}
		else if (_value.equalsIgnoreCase("DE_CONCEPT")) {
			return DEC;
		}
		else if (_value.equalsIgnoreCase("VALUEDOMAIN")) {
			return VD;
		}
		else if (_value.equalsIgnoreCase("OBJECTCLASS")) {
			return OC;
		}
		else if (_value.equalsIgnoreCase("PROPERTY")) {
			return PROP;
		}
		else if (_value.equalsIgnoreCase("CONCEPT")) {
			return CONCEPT;
		}
		else if (_value.equalsIgnoreCase("CONCEPT")) {
			return CONCEPT;
		}
		else if (_value.equalsIgnoreCase("CONCEPTUALDOMAIN")) {
			return CONCEPTUAL_DOMAIN;
		}
		else if (_value.equalsIgnoreCase("REPRESENTATION")) {
			return REPRESENTATION;
		}
		else if (_value.equalsIgnoreCase("CLASSIFICATION")) {
			return CS;
		}
		else if (_value.equalsIgnoreCase("CS_ITEM")) {
			return CSI;
		}
		else {
			 return UNKNOWN;
		}
	}
}
