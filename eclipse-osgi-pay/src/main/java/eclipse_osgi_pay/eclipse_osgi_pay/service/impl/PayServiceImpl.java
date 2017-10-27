package eclipse_osgi_pay.eclipse_osgi_pay.service.impl;

import eclipse_osgi.eclipse_osgi.service.UserService;
import eclipse_osgi_pay.eclipse_osgi_pay.service.PayService;

public class PayServiceImpl implements PayService{
	
   private UserService userService;
    
    
    
    public void setUserService(UserService userService){
    	this.userService = userService;
    }

	@Override
	public void pay() {
		userService.say("pay ");
		
	}

}
