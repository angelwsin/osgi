package eclipse_osgi_user.eclipse_osgi_user;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import eclipse_osgi.eclipse_osgi.service.UserService;

public class Activator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Usermodule启动成功");
		
		ServiceReference<UserService> userRef = context.getServiceReference(UserService.class);
		UserService userService = context.getService(userRef);
		userService.say("hello");
	
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
