package com.cledsonLeite.orquestrator.application.ports.out;

import com.cledsonLeite.orquestrator.application.core.domain.Sale;
import com.cledsonLeite.orquestrator.application.core.domain.enums.SaleEvent;

public interface SendMessageToBrokerOutputPort {
	void send(Sale sale, SaleEvent event, String topic);
}
