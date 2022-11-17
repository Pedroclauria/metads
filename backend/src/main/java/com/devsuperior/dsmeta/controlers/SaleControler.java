package com.devsuperior.dsmeta.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.services.SaleService;
import com.metads.metads.entities.Sale;

@RestController
@RequestMapping(value = "/sales")
public class SaleControler {
	
	@Autowired
	private SaleService service;
	
	//@Autowired
	//private SmsService smsService;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue="") String minDate, 
			@RequestParam(value="maxDate", defaultValue="") String maxDate,
			Pageable pageable){
		return service.findSales(minDate, minDate, pageable);
	}
	
	/*@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	*/
}
