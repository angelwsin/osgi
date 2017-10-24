package eclipse_osgi.eclipse_osgi;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TreeSet;

import org.osgi.framework.Bundle;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class StartOsgi {
	
	
	     public static void main(String[] args) throws Exception{
			  
	    	 InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("profile.core.properties");
	    	 Properties props = new Properties();
	    	 props.load(is);
	    	 ServiceLoader<FrameworkFactory> serviceLoader   = ServiceLoader.load(FrameworkFactory.class);
	     	FrameworkFactory frameworkFactory = serviceLoader.iterator().next();
	     	Map<String,String> configuration = new HashMap<String, String>();
	     	for(Object key : props.keySet()){
	     		 configuration.put((String) key, props.getProperty((String) key));
	     	}
	     	configuration.put("osgi.configuration.area", "D:\\workspace\\eclipse-osgi\\work");
	     	Framework fwk = 	frameworkFactory.newFramework(configuration);
	     	fwk.start();
	     	
	      String  bud =   	configuration.get("launcher.bundles");
	      String[]  buds =  bud.split(",");
	      File file = new File("D:\\alipay\\cloudengine-4.1.2.0\\");
	      Set<Bundle> insBud = new TreeSet<Bundle>();
	      for(String key : buds){
	    	  File bFile = new File(file, key);
	    	 Bundle budl =  fwk.getBundleContext().installBundle(bFile.getAbsoluteFile().toURI().toString());
	    	// budl.start();
	    	 insBud.add(budl);
	      }
	      
	      for(Bundle isb : insBud){
	    	  String fragment = (String)isb.getHeaders().get("Fragment-Host");
	    	          if ((fragment == null) || (fragment.equals("")))
	    	        	  isb.start();
	      }
	      
	    	 
		}

}
