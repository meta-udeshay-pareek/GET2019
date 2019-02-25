package consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configurator.DIConfigurator;
import services.MessageService;

public class MyApplication {
	/*
	 * sendMessage will send the message of given service type
	 * @param requires the service type, message to send, and the receiver to send
	 */
	public void sendMessage(String service,String message,String receiver){

		//connects with the java file which acts as a factory class with spring annotations
		ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(DIConfigurator.class);
		
		//gets the object of requested message service
		MessageService messageService =(MessageService) applicationContext.getBean(service);
		
		//sends the message to receiver with the given message
		messageService.sendMessage(message, receiver);
	}
}
