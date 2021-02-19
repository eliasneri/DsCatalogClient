package com.DsCatalogClient.com.DsCatalogClient.Services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DsCatalogClient.com.DsCatalogClient.Services.exceptions.DataBaseException;
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

	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		Page<ClientDTO> pageDTO = list.map(x -> new ClientDTO(x));
		return pageDTO;
		
		
	}

	public void deleteId(Long id) {
		try {
		 repository.deleteById(id);
		}
		
		catch (EmptyResultDataAccessException e){
			throw new EntityNotFoundException("ID Não Encontrado: " + id);
		}
		
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation!!");
		}
		
		
		
	}
	
	

}
