package com.cledsonLeite.orquestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.orquestrator.adapter.out.SendMessageToBrokerAdapter;
import com.cledsonLeite.orquestrator.application.core.usecase.CreateSaleUsecase;

@Configuration
public class CreateSaleConfig {
	
	@Bean
	public CreateSaleUsecase createSaleUsecase(
			SendMessageToBrokerAdapter brokerAdapter
			) {
		return new CreateSaleUsecase(brokerAdapter);
	}

}
