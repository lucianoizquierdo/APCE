package com.apce.web.helper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.apce.modelo.SolicitudProduccion;
import com.apce.servicio.servicoInterfaz.SolicitudProduccionService;
import com.apce.web.dto.SolicitudProduccionDTO;

@Service
public class SolicitudProduccionHelper {

	@Inject
	SolicitudProduccionService solicitudProduccionService;

	private Integer getSumatoriaCienPorciento(Integer listProcesadas, Integer listNoProcesadas) {
		// TODO Auto-generated method stub

		return listProcesadas + listNoProcesadas;
	}

	public List<SolicitudProduccionDTO> getSoclicitudProduccionDTO() {

		List<SolicitudProduccionDTO> spDtoList = new ArrayList<SolicitudProduccionDTO>();

		List<SolicitudProduccion> spListProcesadas = solicitudProduccionService.getSolicitudProduccionByProcesada(true);

		List<SolicitudProduccion> spListNoProcesadas = solicitudProduccionService.getSolicitudProduccionByProcesada(false);

		Integer sumatoriaCienPorciento = getSumatoriaCienPorciento(spListProcesadas.size(),spListNoProcesadas.size()); 

		SolicitudProduccionDTO spDto1 = new SolicitudProduccionDTO();
		spDto1.setDescripcion("Solicitudes de Produccion Procesadas");
		spDto1.setPorcentaje((spListProcesadas.size() * 100) / sumatoriaCienPorciento);
		spDtoList.add(spDto1);

		SolicitudProduccionDTO spDto2 = new SolicitudProduccionDTO();
		spDto2.setDescripcion("Solicitudes de Produccion No Procesadas");
		spDto2.setPorcentaje((spListNoProcesadas.size() * 100) / sumatoriaCienPorciento);
		spDtoList.add(spDto2);

		return spDtoList;
	}

}
