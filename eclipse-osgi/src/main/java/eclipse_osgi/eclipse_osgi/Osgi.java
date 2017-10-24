package eclipse_osgi.eclipse_osgi;

//https://www.osgi.org/developer/architecture/
public class Osgi {
	
	/*Bundles – Bundles are the OSGi components made by the developers.
	Services – The services layer connects bundles in a dynamic way by offering a publish-find-bind model for plain old Java objects.
	Life-Cycle – The API to install, start, stop, update, and uninstall bundles.
	Modules – The layer that defines how a bundle can import and export code.
	Security – The layer that handles the security aspects.
	Execution Environment – Defines what methods and classes are available in a specific platform.*/
	
	//OSGi服务注册表
	//bundle可以注册一个服务，它可以得到一个服务，它可以监听一个服务出现或消失
	
	/*当多个bundle在同一个接口或类下注册对象时会发生什么？ 这些如何区别？ 答案是属性。 
	每个服务注册都有一套标准和自定义属性。 可以使用表达式的过滤器语言来仅选择您感兴趣的服务。
	属性可用于查找正确的服务或可以在应用程序级别发挥其他角色。*/

}
