package com.devsuperior.sdvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.sdvendas.dto.SellerDTO;
import com.devsuperior.sdvendas.entities.Seller;
import com.devsuperior.sdvendas.repositories.SellerRepository;

@Service
public class SellerServices  {

	@Autowired
	private SellerRepository repository; 
	
	public  List<SellerDTO> findAll(){
		List<Seller> result =  repository.findAll();
		return result.stream().map(x-> new SellerDTO(x)).collect(Collectors.toList());
	}

}
