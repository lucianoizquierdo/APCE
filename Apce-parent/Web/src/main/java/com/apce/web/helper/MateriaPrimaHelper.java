package com.apce.web.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.apce.modelo.MateriaPrima;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;
import com.apce.web.dto.MateriaPrimaDTO;

@Service
public class MateriaPrimaHelper {
	
	@Inject
	MateriaPrimaService materiaPrimaService;
	
	public List<MateriaPrimaDTO> getMateriaPrimaDTO(String nombreMateriaPrima, Date fechaInicio, Date fechaFin)
	{
		List<MateriaPrimaDTO> mpdtoList = new ArrayList<MateriaPrimaDTO>();
		
		Map<MateriaPrima,Integer> map = materiaPrimaService.getMateriaPrimaUtilizada(nombreMateriaPrima, fechaInicio, fechaFin);
		
		Integer sumatoriaCienPorciento = getSumatoriaCienPorciento(map); 
		
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) 
		{
			
			Map.Entry e = (Map.Entry)it.next();
			
			MateriaPrima mp = (MateriaPrima)e.getKey();
			Integer cantidad = ((Integer)e.getValue());
			
			MateriaPrimaDTO mpdto = new MateriaPrimaDTO();
			mpdto.setId(mp.getId());
			mpdto.setCodigoMateriaPrima(mp.getCodigoMateriaPrima());
			mpdto.setDescripcion(mp.getDescripcion());
			
			mpdto.setPorcentaje((cantidad * 100) / sumatoriaCienPorciento);
			
			mpdtoList.add(mpdto);
		}

		return mpdtoList;
	}

	private Integer getSumatoriaCienPorciento(Map<MateriaPrima, Integer> map) {
		// TODO Auto-generated method stub
		
		Integer cantidad = 0;
		Integer sumatoria = 0;
		
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) 
		{
			Map.Entry e = (Map.Entry)it.next();
			
			cantidad = ((Integer)e.getValue());
			sumatoria += cantidad;
		}
		
		return sumatoria;
		
	}

}
