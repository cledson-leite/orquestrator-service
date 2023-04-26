package com.cledsonLeite.orquestrator.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.cledsonLeite.orquestrator.adapter.out.message.SaleMessage;
import com.cledsonLeite.orquestrator.application.core.domain.Sale;
import com.cledsonLeite.orquestrator.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.orquestrator.application.ports.out.SendMessageToBrokerOutputPort;

@Component
public class SendMessageToBrokerAdapter implements SendMessageToBrokerOutputPort{

	@Autowired
	private KafkaTemplate<String, SaleMessage> template;
	
	
	@Override
	public void send(Sale sale, SaleEvent event, String topic) {
		SaleMessage message = new SaleMessage(sale, event);
		template.send(topic, message);
	}

}
