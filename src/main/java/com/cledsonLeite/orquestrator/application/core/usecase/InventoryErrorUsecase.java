package com.cledsonLeite.orquestrator.application.core.usecase;

import com.cledsonLeite.orquestrator.application.core.domain.Sale;
import com.cledsonLeite.orquestrator.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.orquestrator.application.ports.in.WorkFlowInputPort;
import com.cledsonLeite.orquestrator.application.ports.out.SendMessageToBrokerOutputPort;

public class InventoryErrorUsecase implements WorkFlowInputPort{
	
	private SendMessageToBrokerOutputPort brokerOutputPort;
	

	public InventoryErrorUsecase(SendMessageToBrokerOutputPort brokerOutputPort) {
		this.brokerOutputPort = brokerOutputPort;
	}

	@Override
	public void execute(Sale sale) {
		brokerOutputPort.send(sale, SaleEvent.CANCEL_SALE, "topic-saga-sale");
	}

	@Override
	public boolean isCalledByEvent(SaleEvent event) {
		return SaleEvent.INVENTORY_ERROR.equals(event);
	}

}
