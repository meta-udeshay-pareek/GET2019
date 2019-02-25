package test;

import consumer.MyApplication;
import consumer.MyXMLApplication;

public class TestClass {

		
		 MyApplication myApplication = new MyApplication();
		 MyXMLApplication myXMLApplication = new MyXMLApplication();
		
		
		
		public  void testEmailWithXml() {
			myXMLApplication.sendMessage("email", "email with xml bean", "udeshay");
		}

		
		public  void testEmailWithAnnotation() {
			myApplication.sendMessage("email", "email with Annotation bean", "udeshay");
		}
		
		
		
		public  void testTwitterWithXml() {
			myXMLApplication.sendMessage("twitter", "twitter with xml bean", "udeshay");
		}
		
		
		public void testTwitterWithAnnotation() {
			myApplication.sendMessage("twitter", "twitter with Annotation bean", "udeshay");
		}


		public static void main(String [] args){
			TestClass testClass = new TestClass();
			testClass.testEmailWithXml();
			testClass.testEmailWithAnnotation();
			testClass.testTwitterWithXml();
			testClass.testTwitterWithAnnotation();
		}
}
