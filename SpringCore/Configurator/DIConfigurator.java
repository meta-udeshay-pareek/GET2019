package Configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Consumer.MyApplication;
import Services.EmailService;
import Services.MessageService;
import Services.TwitterService;

@Configuration
public class DIConfigurator {
	
	/*
	 * @param email 
	 * @return Object of MyApplication
	 * */
	@Bean
	public MyApplication appEmail(MessageService email){
		return new MyApplication(email);
	}
	
	/*
	 * @param twitter 
	 * @return Object of MyApplication
	 * */
	@Bean
	public MyApplication appTwitter(MessageService twitter){
		return new MyApplication(twitter);
	}
	
	/*
	 * @return Object of EmailService 
	 * */
	@Bean
	public MessageService email(){
		return (MessageService)new EmailService();
	}
	
	/*
	 * @return Object of TwitterService 
	 * */
	@Bean
	public MessageService twitter(){
		return (MessageService)new TwitterService();
	}

}
