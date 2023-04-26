package com.cledsonLeite.orquestrator.application.core.usecase;

import com.cledsonLeite.orquestrator.application.core.domain.Sale;
import com.cledsonLeite.orquestrator.application.core.domain.enums.SaleEvent;
import com.cledsonLeite.orquestrator.application.ports.in.WorkFlowInputPort;
import com.cledsonLeite.orquestrator.application.ports.out.SendMessageToBrokerOutputPort;

public class PaymentFailedUsecase implements WorkFlowInputPort{
	
	private SendMessageToBrokerOutputPort brokerOutputPort;
	

	public PaymentFailedUsecase(SendMessageToBrokerOutputPort brokerOutputPort) {
		super();
		this.brokerOutputPort = brokerOutputPort;
	}

	@Override
	public void execute(Sale sale) {
		brokerOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, "topic-saga-inventory");
		brokerOutputPort.send(sale, SaleEvent.CANCEL_SALE, "topic-saga-sale");
	}

	@Override
	public boolean isCalledByEvent(SaleEvent event) {
		return SaleEvent.PAYMENT_FAILED.equals(event);
	}

}
