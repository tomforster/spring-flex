package org.springframework.flex.messaging;


import flex.messaging.MessageBroker;
import flex.messaging.services.RemotingService;

public class MessageBrokerFactoryBeanTests extends AbstractMessageBrokerTests {

	public void testInitialization() throws Exception {
		
		MessageBroker broker = getMessageBroker();
		
		assertNotNull("MessageBroker was not created.", broker);
		assertEquals("MessageBroker has unexpected ID","testMessageBroker",broker.getId());
		RemotingService remotingService = (RemotingService) broker.getService("remoting-service");
		assertNotNull("remoting-service not found", remotingService);
		assertTrue("The remoting service was not started", remotingService.isStarted());
	}
}