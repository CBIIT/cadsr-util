/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.servicelocator;
import gov.nih.nci.ncicb.cadsr.common.cdebrowser.service.CDEBrowserService;
import gov.nih.nci.ncicb.cadsr.contexttree.service.CDEBrowserTreeService;
import gov.nih.nci.ncicb.cadsr.common.formbuilder.service.LockingService;
import gov.nih.nci.ncicb.cadsr.common.ocbrowser.service.OCBrowserService;

public interface ApplicationServiceLocator
{
  public static final String APPLICATION_SERVICE_LOCATOR_CLASS_KEY = "ApplicationServiceLocatorClassName";

  public OCBrowserService findOCBrowserService() throws ServiceLocatorException;

  public CDEBrowserTreeService findTreeService() throws ServiceLocatorException;

  public CDEBrowserService findCDEBrowserService() throws ServiceLocatorException;
  
  public LockingService findLockingService() throws ServiceLocatorException;
}