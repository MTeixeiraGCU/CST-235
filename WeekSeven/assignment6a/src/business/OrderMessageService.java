package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {

	@EJB
	private OrdersBusinessService service;
	
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	if(message instanceof TextMessage) {
            try {
				System.out.println(((TextMessage)message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
    	}
    	else if(message instanceof ObjectMessage) {
    		try {
    			service.insertOrder((Order)((ObjectMessage)message).getObject());
    		}
    		catch(JMSException e) {
    			e.printStackTrace();
    		}
    	}
    }

}
