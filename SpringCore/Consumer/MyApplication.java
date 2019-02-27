package Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import Services.MessageService;

@Component
public class MyApplication {
	
	MessageService messageService=null;
	
	//constructor-based dependency injection	
	@Autowired
	public MyApplication(MessageService messageService){
		this.messageService = messageService;
	}

	/*
	  * @param message
	  * @param receiver
	  * @return "true" if message has sent else "false"
	  *  */
	public Object sendMessage(String message,String receiver){
		// for e.g. The Email message email with XML bean is sent toVarsha ----->it is for email service call
		//for e.g. The Twitter message twitter with XML bean is sent toVarsha ----->it is for twitter service call
		String acceptedNotification = "The message " + message + " is sent to" + receiver;
		 
		 if(acceptedNotification.equals(messageService.sendMessage(message, receiver))){
			 return true;
		 }
		 
		 return false;
	 }
}

