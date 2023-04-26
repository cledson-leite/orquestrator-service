package com.cledsonLeite.orquestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cledsonLeite.orquestrator.adapter.out.SendMessageToBrokerAdapter;
import com.cledsonLeite.orquestrator.application.core.usecase.PaymentFailedUsecase;

@Configuration
public class PaymentFailedConfig {
	@Bean
	public PaymentFailedUsecase paymentFailedUsecase(
			SendMessageToBrokerAdapter brokerAdapter
			) {
		return new PaymentFailedUsecase(brokerAdapter);
	}

}
