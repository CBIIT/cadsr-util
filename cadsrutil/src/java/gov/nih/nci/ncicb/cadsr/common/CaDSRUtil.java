package gov.nih.nci.ncicb.cadsr.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.Resource;

public class CaDSRUtil {
	
	//Key in cadsrutil.internal.properties mapping to the location of the property file containing "default.context.name"
	protected static String KEY_CADSR_PROPERTIES_PATH = "gov.nih.nci.cadsrutil.properties";
	
	//Key to retrieve the actually default context name
	protected static final String KEY_DEFAULT_CONTEXT_NAME = "default.context.name";
	
	protected static Properties properties = null;

	public static String getDefaultContext() {
		
		try {
			String contextName = CaDSRUtil.getProperty(CaDSRUtil.KEY_DEFAULT_CONTEXT_NAME);
			return contextName;
		} catch (FileNotFoundException fne) {
			return ("FileNotFoundException: " + fne.getMessage());
		} catch (IOException ioe) {
			return ("IOException: " + ioe.getMessage());
		}
	
	}
	
	public static String getProperty(String key) 
			throws IOException {

		if (CaDSRUtil.properties == null || CaDSRUtil.properties.size() == 0) {
			String propPath = CaDSRUtil.getCaDSRPropertyFileName(); 
			CaDSRUtil.properties = loadPropertiesFromFile(propPath);
		}


		return CaDSRUtil.properties.getProperty(key);
	}
	
	protected static Properties loadPropertiesFromFile(String pathname) 
	throws IOException {
		
		properties = new Properties();
		if (pathname == null || pathname.length() == 0)
			return properties;

		FileInputStream in = null;
		in = new FileInputStream(pathname);
		
		if (in != null) {	
			properties.load(in);
			in.close();  
		}
		
		return properties;
	}
	
	protected static String getCaDSRPropertyFileName() {
		
		try {
			Properties internals = loadInternalPropertiesFromClasspath();
			return (internals == null) ? null : internals.getProperty(CaDSRUtil.KEY_CADSR_PROPERTIES_PATH);
		} catch (IOException ioe) {
			return null;
		}
		
	}
	
	protected static Properties loadInternalPropertiesFromClasspath() 
			throws IOException {
		
		Properties internals = new Properties();
		InputStream in = null;

		in = CaDSRUtil.class.getClassLoader().getResourceAsStream(
				"gov/nih/nci/ncicb/cadsr/common/cadsrutil.internal.properties");
		if (in != null) {
			internals.load(in);
			in.close();      
		}

		return internals;
	}

}
