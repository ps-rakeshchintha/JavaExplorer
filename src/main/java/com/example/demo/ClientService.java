package com.example.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    private Map<Long, String> clientIdAndNames;
    @PostConstruct
    private void postConstruct() {
        System.out.println("Called Post Construct");
        List<ClientIdAndName> list = this.clientRepository.getIdAndName();
        this.clientIdAndNames = list.stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
    }

    @Cacheable("getAllClients")
    public List<Client> getAllClients() {
        System.out.println("Get all clients DB call");
        return clientRepository.findAll();
    }

    public List<Client> getAllActiveClients() {
        return clientRepository.findAllByActive(true);
    }
    public Client getClientById(long id) {
        return clientRepository.findById(id);
    }
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }
    public Client createClient(@NotNull Client requestClient) {
        Client client = new Client(requestClient.getName());

        return clientRepository.save(client);
    }
    public Client updateClient(@NotNull Client requestClient, long id) {
        Client dbClient = clientRepository.getById(id);
        Client client = new Client(id, requestClient.getName(), requestClient.getActive(), dbClient.getCreatedDate(), new Date());

        return clientRepository.save(client);
    }

    public Map<Long, String> getIdAndName(){
        return  this.clientIdAndNames;
    }
}
