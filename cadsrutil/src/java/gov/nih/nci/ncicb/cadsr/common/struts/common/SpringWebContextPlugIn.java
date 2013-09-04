/*L
 * Copyright Oracle inc, SAIC-F
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-util/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.common.struts.common;
import gov.nih.nci.ncicb.cadsr.common.servicelocator.spring.SpringObjectLocatorImpl;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringWebContextPlugIn  implements PlugIn 
{


  private ActionServlet servlet;
    


    /**
     * Intializer. Instantiates a new object and adds it to the application context by key
     *
     * @param servlet The ActionServlet for our application
     * @param config  The ModuleConfig for our owning module
     * @throws ServletException if we cannot configure ourselves correctly
     */
    public void init(ActionServlet servlet, ModuleConfig config)
            throws ServletException {
            
   System.out.println(config.toString() + " init " + servlet.toString());
        this.servlet = servlet;
        try {
          ServletContext servletContext = servlet.getServletContext();
          SpringObjectLocatorImpl.applicationContext=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        } catch (Exception e) {

            throw new ServletException("Could not initalize SpringObjectLocatorImpl.applicationContext",e);
        }

    }  
  public void destroy() {
    this.servlet=null;
  }      
}