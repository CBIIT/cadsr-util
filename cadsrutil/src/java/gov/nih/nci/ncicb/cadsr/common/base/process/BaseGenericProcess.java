/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.base.process;

// cleveland imports
import oracle.cle.persistence.HandlerFactory;
import oracle.cle.process.Service;
import oracle.cle.process.GenericProcess;
import oracle.cle.process.ProcessInfoException;
import oracle.cle.util.statemachine.TransitionConditionException;
import oracle.cle.process.ProcessInfo;
import oracle.cle.process.ProcessParameter;
import oracle.cle.process.ProcessResult;

/**
 * @author Gerald P. Momplaisir
 */
public class BaseGenericProcess extends GenericProcess {

  public BaseGenericProcess() {
    this(null);
    DEBUG = false;
  }
  
  public BaseGenericProcess(Service aService) {
    super(aService);
    DEBUG = false;
  }

  /**
   * Retriev an object from the InfoTable from the parameter aKey.
   */
  public Object getInfoObject(String aKey) {
    Object infoValue = null;

    ProcessInfo info = (ProcessInfo)getInfo(aKey);

    if (info!=null && info.isReady()) {
       infoValue = info.getValue();
    }

    return infoValue;
  }

  /**
   * A shortcut for registering an object
   */      
  public void registerParameterObject(String name) throws ProcessInfoException {
    try {
      ProcessParameter pp =
        new ProcessParameter(name,
                             "an object",
                             "This object key is " + name,
                             null);
      registerParameter(pp);
    } // end try
    catch(ProcessInfoException pie) {
      throw pie;
    } // end catch
  } // end 

  /**
   * A shortcut for registering an object
   */
  public void registerResultObject(String prKey) throws ProcessInfoException
  {
    try
    {
      ProcessResult pr =
        new ProcessResult(prKey,
                          prKey + " object key",
                          prKey + " field",
                          this,
                          null);
      registerResult(pr);
    } // end try
    catch(ProcessInfoException pie) {
      throw pie;
    } // end catch
  } // end 

  /**
   * Get a string array from the parameter.  Always returns a string array if null.
   */
  public String[] getInfoStringArray(String aKey) {
  
    Object infoObject = getInfoObject(aKey);
    String[] returnStringArray = null;

    if (infoObject instanceof String[]) {
      returnStringArray = (String[])infoObject;
    }
    else if (infoObject instanceof String) {
      returnStringArray =  new String[]{(String)infoObject};
    }

    return returnStringArray;
  }

}
