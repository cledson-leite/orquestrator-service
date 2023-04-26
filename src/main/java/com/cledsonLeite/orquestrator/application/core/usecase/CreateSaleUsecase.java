package com.cledsonLeite.orquestrator.application.core.usecase;

import com.cledsonLeite.orquestrator.application.core.domain.Sale;
import com.cledsonLeite.orquestrator.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.orquestrator.application.ports.in.WorkFlowInputPort;
import com.cledsonLeite.orquestrator.application.ports.out.SendMessageToBrokerOutputPort;

public class CreateSaleUsecase implements WorkFlowInputPort{
	
	private SendMessageToBrokerOutputPort brokerOutputPort;
	

	public CreateSaleUsecase(SendMessageToBrokerOutputPort brokerOutputPort) {
		this.brokerOutputPort = brokerOutputPort;
	}

	@Override
	public void execute(Sale sale) {
		brokerOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "topic-saga-inventory");
	}

	@Override
	public boolean isCalledByEvent(SaleEvent event) {
		return SaleEvent.CREATE_SALE.equals(event);
	}

}
