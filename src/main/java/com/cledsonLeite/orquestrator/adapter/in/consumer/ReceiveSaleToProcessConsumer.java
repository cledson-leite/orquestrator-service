package com.cledsonLeite.orquestrator.adapter.in.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.cledsonLeite.orquestrator.adapter.out.message.SaleMessage;
import com.cledsonLeite.orquestrator.application.ports.in.WorkFlowInputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveSaleToProcessConsumer {
	@Autowired
	private List<WorkFlowInputPort> workflows;
	
	@KafkaListener(topics = "topic-saga-orquestrator", groupId = "orquestrator")
	public void receive(SaleMessage message) {
		WorkFlowInputPort workflow = workflows
				.stream()
				.filter( item -> item.isCalledByEvent(message.getEvent()))
				.findFirst()
				.orElse(null);
		
		if(workflow != null) {
			workflow.execute(message.getSale());
		}else {
			log.error("Evento nãp encontrado");
		}
	}
}
