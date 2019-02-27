package Test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Configurator.DIConfigurator;
import Consumer.MyApplication;
import Consumer.MyXMLApplication;



public class SpringCoreTest {
	
	

	ApplicationContext contextAuto= new AnnotationConfigApplicationContext(DIConfigurator.class);
	ApplicationContext contextXML= new ClassPathXmlApplicationContext("Configurator/XmlApplicationContext.xml");
	
	
	
	@Test
	public  void testEmailWithAnnotation()
	{
		MyApplication myApplication = (MyApplication) contextAuto.getBean("appEmail");
		assertEquals(true, myApplication.sendMessage("email with Annotation bean", "Varsha"));  
		
	}
	
	@Test
	public  void testEmailWithXml()
	{
		MyXMLApplication myXMLApplication = (MyXMLApplication) contextXML.getBean("appEmail");
		assertEquals(true, myXMLApplication.sendMessage("email with XML bean", "Varsha"));  
	}
	
	@Test
	public void testTwitterWithAnnotation() 
	{
		MyApplication myApplication = (MyApplication) contextAuto.getBean("appTwitter");
		assertEquals(true, myApplication.sendMessage("twitter with Annotation bean", "Varsha"));  
	}
	
	@Test
	public void testTwitterWithXml() 
	{
		MyXMLApplication myXMLApplication = (MyXMLApplication) contextXML.getBean("appTwitter");
		assertEquals(true, myXMLApplication.sendMessage("twitter with XML bean", "Varsha"));  
	}
	

}
