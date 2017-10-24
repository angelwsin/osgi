package eclipse_osgi.eclipse_osgi;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.eclipse.osgi.framework.internal.core.ConsoleManager;
import org.eclipse.osgi.framework.internal.core.Constants;
import org.osgi.framework.Bundle;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
    	//org.osgi.framework.Constants  bundle Manifest 清单文件的配置属性
    	ServiceLoader<FrameworkFactory> serviceLoader   = ServiceLoader.load(FrameworkFactory.class);
    	FrameworkFactory frameworkFactory = serviceLoader.iterator().next();
    	Map<String,String> configuration = new HashMap<String, String>();
    	//console
    	configuration.put(ConsoleManager.PROP_CONSOLE, "localhost:8768");
    	configuration.put(ConsoleManager.PROP_CONSOLE_ENABLED, "true");
    	//Profile
    	configuration.put("osgi.profile.startup", "true");
    	//BaseAdaptor   自定父类加载器
    	configuration.put(Constants.FRAMEWORK_BUNDLE_PARENT, "fwk");
    	//BaseStorage    清空缓存
    	configuration.put("osgi.clean", "true");
    	//SystemBundleData.OSGI_FRAMEWORK  系统的bundle 路径
    	//org.osgi.framework.bootdelegation
    	//bootdelegation
    	//configuration.put("org.osgi.framework.bootdelegation", "")
    	//org.osgi.framework.system.packages
    	Framework  framework = frameworkFactory.newFramework(configuration);
    	framework.start();
    	File file = new File("D:\\alipay\\cloudengine-4.1.2.0\\lib\\com.springsource.slf4j.api-1.6.1.jar");
    	Bundle bundle = framework.getBundleContext().installBundle(file.getAbsoluteFile().toURI().toString());
    	bundle.start();
    	String fragment = (String)bundle.getHeaders().get("Fragment-Host");
        if ((fragment == null) || (fragment.equals("")))
        	bundle.start();
    	
    }
}
