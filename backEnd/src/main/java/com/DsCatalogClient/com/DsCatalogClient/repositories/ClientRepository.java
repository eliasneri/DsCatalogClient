package com.DsCatalogClient.com.DsCatalogClient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DsCatalogClient.com.DsCatalogClient.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
