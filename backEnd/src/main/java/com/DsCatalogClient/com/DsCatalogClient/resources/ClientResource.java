package com.DsCatalogClient.com.DsCatalogClient.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DsCatalogClient.com.DsCatalogClient.Services.ClientService;
import com.DsCatalogClient.com.DsCatalogClient.dto.ClientDTO;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
