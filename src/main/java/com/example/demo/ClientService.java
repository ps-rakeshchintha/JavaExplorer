package com.example.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Map<Long, String> getIdAndName(){
        List<ClientIdAndName> list = clientRepository.getIdAndName();
        Map<Long, String> map = list.stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
        return  map;
    }
}
