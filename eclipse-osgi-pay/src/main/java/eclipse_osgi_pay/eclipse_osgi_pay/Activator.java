package eclipse_osgi_pay.eclipse_osgi_pay;

import java.util.Objects;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import eclipse_osgi_pay.eclipse_osgi_pay.service.PayService;

public class Activator implements BundleActivator{

	public void start(BundleContext context) throws Exception {
		
		ServiceReference<PayService> payRef = context.getServiceReference(PayService.class);
		if(!Objects.isNull(payRef)){
			context.getService(payRef).pay();
		}
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
		
		
	

}
