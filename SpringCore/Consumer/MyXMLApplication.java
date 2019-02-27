package Consumer;


import org.springframework.stereotype.Component;



import com.sun.org.apache.bcel.internal.generic.RETURN;

import Services.MessageService;

@Component
public class MyXMLApplication {
	
	 MessageService messageService=null;
	
	 //constructor-based dependency injection
	 public MyXMLApplication(MessageService messageService) {
		this.messageService=messageService;
	 }

	 /*
	  * @param message
	  * @param receiver
	  * @return "true" if message has sent else "false"
	  *  */
	 public boolean sendMessage(String message,String receiver){
		 // for e.g. The Email message email with Annotation bean is sent toVarsha ----->it is for email service call
		 //for e.g. The Twitter message twitter with Annotation bean is sent toVarsha ----->it is for twitter service call
		 String acceptedNotification = "The message " + message + " is sent to" + receiver;
		 
		 
		 System.out.println(acceptedNotification);
		 System.out.println(messageService.sendMessage(message, receiver));
		 if(acceptedNotification.equals(messageService.sendMessage(message, receiver))){
			 return true;
		 }
		 
		 return false;
	 }
}
