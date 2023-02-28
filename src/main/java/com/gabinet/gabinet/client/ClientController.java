package com.gabinet.gabinet.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/client")
@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public Client add(@RequestBody Client client){
        return clientService.add(client);
    }

    @GetMapping("/all")
    public List<Client> all(){
        return clientService.all();
    }

    @GetMapping("/{id}")
    public Optional<Client> byId(@PathVariable Long id){
        return clientService.byId(id);
    }

    @PostMapping("/{id}/delete")
    public void deleteById(@PathVariable Long id){
        clientService.deleteById(id);
    }

//    @PostMapping("/delete")
//    public void deleteAll(){
//        clientService.deleteAll();
//    }

}
