package work.javiermantilla.proyecto.services;

import work.javiermantilla.proyecto.dto.DataListDTO;

public interface IRequiredRemainderServices {
	
		
	DataListDTO process(DataListDTO data);	
	DataListDTO processGet(String[] data);
	
}
