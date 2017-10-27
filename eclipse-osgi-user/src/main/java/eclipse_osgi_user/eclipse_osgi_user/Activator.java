package eclipse_osgi_user.eclipse_osgi_user;

import java.util.Dictionary;
import java.util.Objects;

import org.eclipse.equinox.internal.ds.SCRManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.SynchronousBundleListener;
import org.osgi.service.component.ComponentConstants;

import eclipse_osgi.eclipse_osgi.service.UserService;

public class Activator implements BundleActivator,SynchronousBundleListener{
	
	
	BundleContext context ;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Usermodule启动成功");
		this.context = context;
		
		context.addBundleListener(this);
	
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
		
		ServiceReference<UserService> userRef = context.getServiceReference(UserService.class);
		if(!Objects.isNull(userRef)){
			UserService userService = context.getService(userRef);
			userService.say("hello");
		}
		
		
	}

	@Override
	public void bundleChanged(BundleEvent event) {
		if (event.getType() == BundleEvent.STARTED || event.getType() == BundleEvent.LAZY_ACTIVATION) {
			ServiceReference<UserService> ref = context.getServiceReference(UserService.class);
			if(!Objects.isNull(ref)){
				UserService o =  context.getService(ref);
				  o.say("hello");
			}
				context.removeBundleListener(this);
			}
		
		}
		
	

}
