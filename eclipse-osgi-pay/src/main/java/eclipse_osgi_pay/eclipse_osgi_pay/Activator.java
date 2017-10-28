package eclipse_osgi_pay.eclipse_osgi_pay;

import java.util.Objects;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

import eclipse_osgi_pay.eclipse_osgi_pay.service.PayService;

public class Activator implements BundleActivator,ServiceListener{
	
	private BundleContext context;

	//重新new 一个BundleContext 把fwk对象放进去
	public void start(BundleContext context) throws Exception {
		
		ServiceReference<PayService> payRef = context.getServiceReference(PayService.class);
		if(!Objects.isNull(payRef)){
			context.getService(payRef).pay();
		}
		this.context = context;
		context.addServiceListener(this);
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		System.out.println("---"+event.getSource().getClass());
		if(event.getType()==ServiceEvent.REGISTERED){
			PayService payService = (PayService) context.getService((ServiceReference)event.getSource());
			payService.pay();
		}
		
	}

	
		
		
	

}
