package eclipse_osgi.eclipse_osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

public class OsigStart implements BundleActivator,EventHandler{
	
	private EventAdmin  eventAdmin ;

	public void start(BundleContext context) throws Exception {
		
		/*ServiceReference<?> serviceRef = context.getServiceReference(EventAdmin.class.getName());
		eventAdmin = (EventAdmin) context.getService(serviceRef);
		 String[] topics = new String[] {"xxxx"};
		  Hashtable ht = new Hashtable();
		  ht.put(EventConstants.EVENT_TOPIC, topics);
		  context.registerService(EventHandler.class.getName(), this, ht);
		  eventAdmin.sendEvent(new Event("xxxx", new HashMap<>()));*/
		System.out.println("启动成功");
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleEvent(Event event) {
		System.out.println(event.getTopic());
		
	}

}
