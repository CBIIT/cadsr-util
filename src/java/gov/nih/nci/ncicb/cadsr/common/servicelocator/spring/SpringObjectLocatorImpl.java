package gov.nih.nci.ncicb.cadsr.common.servicelocator.spring;
import gov.nih.nci.ncicb.cadsr.common.servicelocator.ObjectLocator;
import gov.nih.nci.ncicb.cadsr.common.servicelocator.ServiceLocatorException;
import gov.nih.nci.ncicb.cadsr.spring.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;


public class SpringObjectLocatorImpl implements ObjectLocator

{
  public static ApplicationContext applicationContext = null;
  public SpringObjectLocatorImpl()
  {
  }
  
  public Object findObject(String key)
  {
System.out.println("findobject " + key);
	if(applicationContext==null)
      throw new ServiceLocatorException("applicationContext is null");
     return applicationContext.getBean(key);
  }
  
}