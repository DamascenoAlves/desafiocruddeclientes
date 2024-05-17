package com.damascenoalves.desafiocruddeclientes.services;


import com.damascenoalves.desafiocruddeclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

}
