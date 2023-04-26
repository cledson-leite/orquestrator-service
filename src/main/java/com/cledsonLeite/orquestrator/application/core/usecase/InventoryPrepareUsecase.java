package com.cledsonLeite.orquestrator.application.core.usecase;

import com.cledsonLeite.orquestrator.application.core.domain.Sale;
import com.cledsonLeite.orquestrator.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.orquestrator.application.ports.in.WorkFlowInputPort;
import com.cledsonLeite.orquestrator.application.ports.out.SendMessageToBrokerOutputPort;

public class InventoryPrepareUsecase implements WorkFlowInputPort{
	
	private SendMessageToBrokerOutputPort brokerOutputPort;
	

	public InventoryPrepareUsecase(SendMessageToBrokerOutputPort brokerOutputPort) {
		this.brokerOutputPort = brokerOutputPort;
	}

	@Override
	public void execute(Sale sale) {
		brokerOutputPort.send(sale, SaleEvent.EXECUTE_PAYMENT, "topic-saga-payment");
	}

	@Override
	public boolean isCalledByEvent(SaleEvent event) {
		return SaleEvent.PREPARE_INVENTORY.equals(event);
	}

}
