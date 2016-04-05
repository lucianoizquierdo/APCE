package com.apce.web.helper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.apce.modelo.OrdenProduccion;
import com.apce.servicio.servicoInterfaz.OrdenProduccionService;
import com.apce.web.dto.OrdenProduccionDTO;

@Service
public class OrdenProduccionHelper {

	@Inject
	OrdenProduccionService OrdenProduccionService;

	private Integer getSumatoriaCienPorciento(Integer listProcesadas, Integer listNoProcesadas) {
		// TODO Auto-generated method stub

		return listProcesadas + listNoProcesadas;
	}

	public List<OrdenProduccionDTO> getOrdenProduccionDTO() {

		List<OrdenProduccionDTO> opDtoList = new ArrayList<OrdenProduccionDTO>();

		List<OrdenProduccion> opListProcesadas = OrdenProduccionService.getOrdenProduccionByProcesada(true);

		List<OrdenProduccion> opListNoProcesadas = OrdenProduccionService.getOrdenProduccionByProcesada(false);

		Integer sumatoriaCienPorciento = getSumatoriaCienPorciento(opListProcesadas.size(),opListNoProcesadas.size()); 

		OrdenProduccionDTO opDto1 = new OrdenProduccionDTO();
		opDto1.setDescripcion("Ordenes de Produccion Procesadas");
		opDto1.setPorcentaje((opListProcesadas.size() * 100) / sumatoriaCienPorciento);
		opDtoList.add(opDto1);

		OrdenProduccionDTO opDto2 = new OrdenProduccionDTO();
		opDto2.setDescripcion("Ordenes de Produccion No Procesadas");
		opDto2.setPorcentaje((opListNoProcesadas.size() * 100) / sumatoriaCienPorciento);
		opDtoList.add(opDto2);

		return opDtoList;
	}

}
