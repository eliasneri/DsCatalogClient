package com.DsCatalogClient.com.DsCatalogClient.Services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DsCatalogClient.com.DsCatalogClient.Services.exceptions.DataBaseException;
import com.DsCatalogClient.com.DsCatalogClient.Services.exceptions.ResourceNotFoundException;
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
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found!"));
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
			throw new ResourceNotFoundException("ID Não Encontrado: " + id);
		}
		
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation!!");
		}
	
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			entity.setIncome(dto.getIncome());
			entity.setCpf(dto.getCpf());
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}
		
		catch (EntityNotFoundException e){
			throw new ResourceNotFoundException("ID Não Encontrado: " + id);
		}			
		
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setIncome(dto.getIncome());
		entity.setCpf(dto.getCpf());
		entity = repository.save(entity);
		return new ClientDTO(entity);
		
	}

	@Transactional(readOnly = true)
	public List<ClientDTO> findAllReg() {
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
	
	
}
