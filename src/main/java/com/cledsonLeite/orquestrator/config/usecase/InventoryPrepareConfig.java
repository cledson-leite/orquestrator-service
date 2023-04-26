package com.cledsonLeite.orquestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.orquestrator.adapter.out.SendMessageToBrokerAdapter;
import com.cledsonLeite.orquestrator.application.core.usecase.InventoryPrepareUsecase;

@Configuration
public class InventoryPrepareConfig {
 @Bean
 public InventoryPrepareUsecase inventoryPrepareUsecase(
		 SendMessageToBrokerAdapter brokerAdapter
		 ) {
	 return new InventoryPrepareUsecase(brokerAdapter);
 }
}
