package com.gabinet.gabinet.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client add(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> all() {
        return clientRepository.findAll();
    }

    public Optional<Client> byId(Long id){
        return clientRepository.findById(id);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

//    public void deleteAll(){
//        clientRepository.deleteAll();
//    }

}
