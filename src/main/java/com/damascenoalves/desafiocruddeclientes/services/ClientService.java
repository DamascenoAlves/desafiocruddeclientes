package com.damascenoalves.desafiocruddeclientes.services;


import com.damascenoalves.desafiocruddeclientes.dto.ClientDTO;
import com.damascenoalves.desafiocruddeclientes.repositories.ClientRepository;
import com.damascenoalves.desafiocruddeclientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        ClientDTO dto = new ClientDTO(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Recurso nao encontrado")));
        return dto;
    }

}
