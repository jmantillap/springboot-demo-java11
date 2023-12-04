package work.javiermantilla.proyecto.services.impl;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import work.javiermantilla.proyecto.dto.DataListDTO;
import work.javiermantilla.proyecto.services.IRequiredRemainderServices;

@Service
public class RequiredRemainderServices implements IRequiredRemainderServices {

	
	
	@Override
	public DataListDTO process(DataListDTO data) {
		
		data.getData().forEach(i->{
			int x=i.getX();
			int y =	i.getY();
			int n = i.getN();
			int z = n % x;
			if (z > y) {
				n -= (z - y);				
				i.setOutput(n);				
			} else if (z == y) {
				i.setOutput(n);				
			} else {
				n -= x;
				n += (y - z);
				i.setOutput(n);				
			}			
		});
		
		return data;
	}

	@Override
	public DataListDTO processGet(String[] data) {
		DataListDTO dataList= new DataListDTO();
		dataList.setData(new ArrayList<>());
		for (int i = 0; i < data.length; i++) {
			String[] input= data[i].split(","); 
			DataListDTO.DataItem item= new DataListDTO.DataItem();			
			for (int j = 0; j < input.length; j++) {
				if(j==0) {
					item.setX(Integer.parseInt(input[j]));
				}else if(j==1) {
					item.setY(Integer.parseInt(input[j]));
				}else if(j==2) {
					item.setN(Integer.parseInt(input[j]));
				}
			}
			dataList.getData().add(item);
		}		
		dataList= this.process(dataList);		
		return dataList;
	}

}
