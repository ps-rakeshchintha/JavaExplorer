package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientService.getAllClients();
    }
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable long id){
        return clientService.getClientById(id);
    }
    @GetMapping("/clients/active")
    public List<Client> getActiveClients(){
        return clientService.getAllActiveClients();
    }
    @GetMapping("/clients/actives")
    public List<Client> getActiveClientsS(){
        return clientService.getAllActiveClients();
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClientById(id);
    }
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }
    @PutMapping("/clients/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable long id){
        return clientService.updateClient(client, id);
    }

}
