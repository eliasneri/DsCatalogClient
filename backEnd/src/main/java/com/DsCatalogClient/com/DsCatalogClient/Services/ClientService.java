package com.DsCatalogClient.com.DsCatalogClient.Services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DsCatalogClient.com.DsCatalogClient.Services.exceptions.EntityNotFoundException;
import com.DsCatalogClient.com.DsCatalogClient.dto.ClientDTO;
import com.DsCatalogClient.com.DsCatalogClient.entities.Client;
import com.DsCatalogClient.com.DsCatalogClient.repositories.ClientRepository;

@Service
public class ClientService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity Not Found!"));
		return new ClientDTO(entity);
	}
	
	

}
