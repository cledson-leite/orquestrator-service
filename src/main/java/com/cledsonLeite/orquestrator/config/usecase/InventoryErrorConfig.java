package com.cledsonLeite.orquestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.orquestrator.adapter.out.SendMessageToBrokerAdapter;
import com.cledsonLeite.orquestrator.application.core.usecase.InventoryErrorUsecase;

@Configuration
public class InventoryErrorConfig {
	@Bean
	public InventoryErrorUsecase inventoryErrorUsecase(SendMessageToBrokerAdapter brokerAdapter) {
		return new InventoryErrorUsecase(brokerAdapter);
	}
}
