package com.devsuperior.sdvendas.service;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.sdvendas.dto.SaleDTO;
import com.devsuperior.sdvendas.dto.SaleSuccessDTO;
import com.devsuperior.sdvendas.dto.SaleSumDTO;
import com.devsuperior.sdvendas.entities.Sale;
import com.devsuperior.sdvendas.repositories.SaleRepository;
import com.devsuperior.sdvendas.repositories.SellerRepository;

@Service
public class SaleService  {

	@Autowired
	private SaleRepository repository; 
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public  Page<SaleDTO> findAll(Pageable pageble){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageble);
		return result.map(x-> new SaleDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
	

}
