package gov.nih.nci.ncicb.cadsr.common.struts.formbeans;

import java.util.Iterator;
import java.util.Map;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;


/**
 * Not decided what should go in here
 */
public class GenericDynaFormBean extends DynaValidatorForm {
  public void clear() {
    Map map = getMap();
    Iterator keys = map.keySet().iterator();

    while (keys.hasNext()) {
      String key = (String) keys.next();
      map.put(key, "");
    }
  }
  
  public void initialize(ActionMapping mapping) {
	  
  }
}
