package com.cledsonLeite.orquestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.orquestrator.adapter.out.SendMessageToBrokerAdapter;
import com.cledsonLeite.orquestrator.application.core.usecase.PaymentExecutedUsecase;

@Configuration
public class PaymentExecutedConfig {
	
	@Bean
	public PaymentExecutedUsecase paymentExecutedUsecase(
			SendMessageToBrokerAdapter brokerAdapter
			) {
		return new PaymentExecutedUsecase(brokerAdapter);
	}

}
