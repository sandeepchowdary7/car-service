package com.carservice.carservice.controllers;

import com.carservice.carservice.models.Clients;
import com.carservice.carservice.services.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    private Object getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    private Object getClient(@PathVariable("clientId") int id) {
       return clientService.getClientById(id);
    }

    @PostMapping("/client")
    private Object saveClient(@RequestBody Clients client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/client/{clientId}")
    private Object updateClient(@RequestBody Clients client, @PathVariable("clientId") int id) {
        return clientService.updateClient(client, id);
    }

    @DeleteMapping("client/{clientId}")
    private Object deleteClient(@PathVariable("clientId")  int id) {
        return clientService.deleteClientById(id);
    }
}
