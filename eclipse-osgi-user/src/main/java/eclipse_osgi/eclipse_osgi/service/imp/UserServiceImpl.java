package eclipse_osgi.eclipse_osgi.service.imp;

import eclipse_osgi.eclipse_osgi.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public void say(String say) {
		System.out.println(say);
		
	}
	
	public void activate(){
		System.out.println("activate ");
	}

}
