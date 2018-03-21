package asw.kafkamanager;

import org.springframework.beans.factory.annotation.Autowired;

import asw.dbManagement.model.Incidence;
import asw.kafkamanager.producers.KafkaProducer;

public class SendIncidenceImpl implements SendIncidence{
	
	@Autowired
	KafkaProducer kafkaProducer;
	private final static String TOPIC = "Incidencia";

	@Override
	public String createMessage(Incidence incidence) {
		
		return incidence.toString();
	
	}

	@Override
	public void send(String message) {
		kafkaProducer.send(TOPIC, message);
	}
	
	

}
