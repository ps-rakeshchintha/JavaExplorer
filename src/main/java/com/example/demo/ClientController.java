package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    CacheManager cacheManager;

    @PostConstruct
    private void postConstruct() {
        System.out.println("Called Controller Post Construct");
        this.clientService.getAllClients();
    }

    @Scheduled(fixedRate = 6000)
    public void testCache() {
        System.out.println("Test Cache");
        this.clientService.getAllClients();
    }

    @Scheduled(fixedRate = 60000)
    public void evictGetAllClientsCache() {
        System.out.println("Clear Cache");
        cacheManager.getCache("getAllClients").clear();
        System.out.println("Get Clients Again");
        this.clientService.getAllClients();
    }

    @GetMapping("/clients")
    public List<Client> getClients(){
        System.out.println("Get Clients Controller");
        return clientService.getAllClients();
    }
    @GetMapping("/clientsni")
    public Map<Long, String> getIdAndName(){
        return clientService.getIdAndName();
    }
    @GetMapping("/clientsia")
    public Map<Long, Boolean> getIdAndActive(){
        return clientService.getIdAndActive();
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
