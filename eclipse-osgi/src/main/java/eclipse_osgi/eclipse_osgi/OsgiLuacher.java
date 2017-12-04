package eclipse_osgi.eclipse_osgi;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleWiring;
//-agentlib:jdwp=transport=dt_socket,server=y,address=8000,suspend=n
//org.osgi.framework.Constants

public class OsgiLuacher {
	
	private static String LauncherBundles ="launcher.bundles";
	private static String Home = System.getProperty("user.dir");
	
	//mvn install:install-file -Dfile=D:\osgi\plugins\org.eclipse.osgi.services_3.3.100.v20120522-1822.jar -DgroupId=org.eclipse -DartifactId=org.eclipse.osgi.services -Dversion=3.3.100.v20120522-1822 -Dpackaging=jar
	//mvn install:install-file -Dfile=D:\osgi\plugins\org.eclipse.equinox.util_1.0.400.v20120522-2049.jar -DgroupId=org.eclipse.equinox -DartifactId=org.eclipse.equinox.util -Dversion=1.0.400.v20120522-2049 -Dpackaging=jar
	//mvn install:install-file -Dfile=D:\osgi\plugins\org.eclipse.equinox.ds_1.4.0.v20120522-1841.jar -DgroupId=org.eclipse.equinox -DartifactId=org.eclipse.equinox.ds -Dversion=1.4.0.v20120522-1841 -Dpackaging=jar
	//mvn install:install-file -Dfile=D:\osgi\plugins\org.eclipse.equinox.common_3.6.100.v20120522-1841.jar -DgroupId=org.eclipse.equinox -DartifactId=org.eclipse.equinox.common -Dversion=3.6.100.v20120522-1841 -Dpackaging=jar
	//mvn install:install-file -Dfile=D:\osgi\plugins\org.eclipse.equinox.cm_1.0.400.v20120522-1841.jar -DgroupId=org.eclipse.equinox -DartifactId=org.eclipse.equinox.cm -Dversion=1.0.400.v20120522-1841 -Dpackaging=jar
	//mvn install:install-file -Dfile=D:\osgi\plugins\org.eclipse.equinox.app_1.3.100.v20120522-1841.jar -DgroupId=org.eclipse.equinox -DartifactId=org.eclipse.equinox.app -Dversion=1.3.100.v20120522-1841 -Dpackaging=jar
   //mvn install:install-file -Dfile=D:\osgi\plugins\org.eclipse.equinox.registry_3.5.200.v20120522-1841.jar -DgroupId=org.eclipse.equinox -DartifactId=org.eclipse.equinox.registry -Dversion=3.5.200.v20120522-1841 -Dpackaging=jar
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try( InputStream is = OsgiLuacher.class.getClassLoader().getSystemResourceAsStream("osgi.properties");) {
			 Properties ps = new Properties();
			 ps.load(is);
			 Map<String,String> config = new HashMap<>(ps.size());
			 ps.keySet().forEach(key ->{
				 String k = key.toString();
				 String v = ps.getProperty(key.toString()).toString();
				 config.put(k, v);
			 });
             
			 ServiceLoader<FrameworkFactory> serviceLoader   = ServiceLoader.load(FrameworkFactory.class);
		    	FrameworkFactory frameworkFactory = serviceLoader.iterator().next();
		    	Framework fw = frameworkFactory.newFramework(config);
		    	fw.start();
		    	// 创建框架对象
		    	//初始化配置 如osgi.configuration.area  等 框架安装位置
		    	//初始化 BaseAdaptor  框架功能的扩展点 
		    	   //  BaseAdaptor 通过管理HookRegistry 来完成功能的扩展
		    	    //initialize the hook configurators        实现 org.eclipse.osgi.baseadaptor.HookRegistry.initialize()
		    	      // classpath :/hookconfigurators.properties
		    	     // 框架配置 osgi.hook.configurators.include，osgi.hook.configurators.exclude
		    	     //HookConfigurator#addHooks(HookRegistry)
		    	     //初始化storage  
		    	//启动ConsoleManager 服务     osgi.console
		       //Start the SystemBundle, launches the framework
		    // 启动事件服务和监听 org.eclipse.osgi.framework.internal.core.StartLevelManager.initialize()
		    //启动 begin tracking services 
		        parseLauncherBundles(config.get(LauncherBundles)).forEach(bundle->{
		        	try {
						Bundle bundl = fw.getBundleContext().installBundle(bundle.toExternalForm());
						
						bundl.start();
						BundleWiring wi = bundl.adapt(BundleWiring.class);
						if(wi!=null){
							System.out.println(wi.getRequirements("osgi.wiring.package"));
						}
					} catch (BundleException   e) {
						e.printStackTrace();
					}
		        });
		    
		    	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static List<URL>  parseLauncherBundles(String key){
		    String[] bundles = key.split(",");
		    List<URL> urls = new ArrayList<>(bundles.length);
		    URL context;
		    try {
			context = new URL(String.format("%s%s%s", "file:/",Home,"/"));
			Arrays.asList(bundles).forEach(bundle->{
				try {
					urls.add(new URL(context, bundle.split("@")[0]));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			});
		    } catch (MalformedURLException e) {
			e.printStackTrace();
		    }
		    return urls;
		    
	}
	
	
	//Life Cycle of a Framework
	
	// init 
	  //--(1.Start Extension Activators 2.Init Framework Listeners)
	// Starting the Framework
	// Stopping a Framework
	       //--(Stop Extension Activators)
	
	
	//Bundle State
	
	//INSTALLED
	//RESOLVED - resolved the bundle's dependencies as described in the manifest
	//STARTING -  BundleActivator.start method will be called
	//ACTIVE  its Bundle Activator start method has been called and returned.
	//STOPPING -he BundleActivator.stop method has been called but the stop method has not yet returned
	//UNINSTALLED
	
	
	//Events
	//BundleEvent -
	//FrameworkEvent -
	
	/*BundleActivator
	• ServiceFactory
	• BundleListener, ServiceListener, and FrameworkListener
	• Framework hook services
	*/
	
	
	//ServiceEvent 
	//ServiceTracker 提供线程安全的跟踪
	//ServiceRegistration  注册 LdapFilter查找
}
