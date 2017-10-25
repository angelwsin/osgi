package eclipse_osgi.eclipse_osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class OsigStart implements BundleActivator{

	public void start(BundleContext context) throws Exception {
		
		System.out.println("启动成功");
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
