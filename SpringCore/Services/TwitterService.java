package Services;

public class TwitterService implements MessageService
{

	/*
	 * @param message 
	 * @param receiver
	 * */
	public String sendMessage(String message, String receiver)
	{
		return ("The message " + message + " is sent to" + receiver);
	}
}
