package com.DsCatalogClient.com.DsCatalogClient.Services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DsCatalogClient.com.DsCatalogClient.entities.Client;
import com.DsCatalogClient.com.DsCatalogClient.repositories.ClientRepository;

@Service
public class ClienteService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
		
	}
	
}
