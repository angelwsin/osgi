package eclipse_osgi_pay.eclipse_osgi_pay.service.impl;

import org.osgi.service.component.ComponentContext;

import eclipse_osgi.eclipse_osgi.service.UserService;
import eclipse_osgi_pay.eclipse_osgi_pay.service.PayService;

public class PayServiceImpl implements PayService{
	
   private UserService userService;
   
   
   //参数支持 see ServiceComponent
   public void activate(ComponentContext context){
	   
	  // System.out.println(context);
	   
   }
    
 //参数支持 see ServiceComponent 
 public void deactivate(){
	   
   }
    
    public void setUserService(UserService userService){
    	this.userService = userService;
    }

	@Override
	public void pay() {
		userService.say("pay ");
		
	}

}
