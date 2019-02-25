package services;

public interface MessageService {
	/*
	 * @param message which is to be send 
	 * @param receiver ,to whom message is going to send
	 * */
	public void sendMessage(String message,String receiver);
}
