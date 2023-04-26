package com.cledsonLeite.orquestrator.application.ports.in;

import com.cledsonLeite.orquestrator.application.core.domain.Sale;
import com.cledsonLeite.orquestrator.application.core.domain.enums.SaleEvent;

public interface WorkFlowInputPort {
	void execute(Sale sale);
	boolean isCalledByEvent(SaleEvent event);
}
