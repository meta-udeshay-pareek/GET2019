package configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import services.EmailService;
import services.TwitterService;


@Configuration
public class DIConfigurator {
	
	/*
	 * @return returning EmailService Object
	 * */
	@Bean
	public EmailService email(){
		return new EmailService();
	}
	

	/*
	 * @return returning TwitterService Object
	 * */
	@Bean
	public TwitterService twitter(){
		return new TwitterService();
	}

}
