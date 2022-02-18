package com.example.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAllClients() {
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
}