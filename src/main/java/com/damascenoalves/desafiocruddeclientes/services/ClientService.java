package com.damascenoalves.desafiocruddeclientes.services;


import com.damascenoalves.desafiocruddeclientes.dto.ClientDTO;
import com.damascenoalves.desafiocruddeclientes.entities.Client;
import com.damascenoalves.desafiocruddeclientes.repositories.ClientRepository;
import com.damascenoalves.desafiocruddeclientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        ClientDTO dto = new ClientDTO(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Recurso nao encontrado")));
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO>  findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
