package eclipse_osgi.eclipse_osgi.event;

import java.util.Map;

import org.eclipse.osgi.framework.eventmgr.CopyOnWriteIdentityMap;
import org.eclipse.osgi.framework.eventmgr.EventDispatcher;
import org.eclipse.osgi.framework.eventmgr.EventManager;
import org.eclipse.osgi.framework.eventmgr.ListenerQueue;

public class EventDis implements EventDispatcher<Object, Object, StartEvent>{
	
	
	public static void main(String[] args) {
		EventManager eventManager = new EventManager("event mananger ");
		Map eventListeners = new CopyOnWriteIdentityMap();
		 
		 	// Add a SomeEventListener to the listener list
		eventListeners.put(new EventDis(), null);
		ListenerQueue listenerQueue = new ListenerQueue(eventManager);
		 	// Add the listeners to the queue and associate them with the event dispatcher
		 	listenerQueue.queueListeners(eventListeners.entrySet(), new EventDis());
		 	// Deliver the event to the listeners. 
		 	listenerQueue.dispatchEventAsynchronous(0, new StartEvent(""));
		 	
		 	/*
		 	 * 监听器 监听对象   事件分发器
		 	 */
		
	}

	public void dispatchEvent(Object eventListener, Object listenerObject, int eventAction, StartEvent eventObject) {
		
		
	}

	
	//BundleEvent   SynchronousBundleListener,BundleListener 监听
	
 //状态  Bundle中
	

}
