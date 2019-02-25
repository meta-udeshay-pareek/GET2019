package services;

public class TwitterService implements MessageService {

	@Override
	public void sendMessage(String message, String receiver) {
		
		System.out.println("Twitter message has sent to "+receiver+" with message: "+message);
		
	}
	
}
