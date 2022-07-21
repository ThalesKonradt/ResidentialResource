package com.residentialresources.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.residentialresources.model.Imovel;
import com.residentialresources.model.ResponseData;
import com.residentialresources.repository.ResidentialResourcesRepository;

@Service
public class ResidentialResourcesService {
	
	@Autowired
	private ResidentialResourcesRepository repository;
	

	public ResponseData filterPropertyList(String dormitoriesNumber, String hasPool) throws JsonProcessingException {
		List<Imovel> propertyList = repository.findPorpertyList();
		
		if(!dormitoriesNumber.isBlank()) {
			propertyList = propertyList.stream().filter(p -> p.getDormitorios() == Integer.valueOf(dormitoriesNumber)).collect(Collectors.toList());
		}
		if(!hasPool.isBlank()) {
			propertyList = propertyList.stream().filter(p -> p.isTemPiscina() == hasPool.equalsIgnoreCase("true")).collect(Collectors.toList());
		}
		
		return new ResponseData(propertyList);	
	}
	
}
