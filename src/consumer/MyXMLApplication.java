package consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.MessageService;






public class MyXMLApplication {
		
	/*
	 * sendMessage will send the message of given service type
	 * @param requires the service type, message to send, and the receiver to send
	 */
	public void sendMessage(String service,String message,String receiver){
		
		//connects with xml file 
		ApplicationContext context = new ClassPathXmlApplicationContext("configurator/applicationContext.xml");
		
		//getting object according to service
		MessageService messageService = (MessageService) context.getBean(service);
		
		//calling sendMessage Method for sending message
		messageService.sendMessage(message, receiver);
	}
}
