package com.damascenoalves.desafiocruddeclientes.controllers;


import com.damascenoalves.desafiocruddeclientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;
}