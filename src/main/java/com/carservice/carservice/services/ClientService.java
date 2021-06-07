package com.carservice.carservice.services;

import com.carservice.carservice.models.Clients;
import com.carservice.carservice.models.Shops;
import com.carservice.carservice.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Object getAllClients() {
        List<Clients> clients = new ArrayList();
        clientRepository.findAll().forEach(clients1 -> clients.add(clients1));
        if (clients.isEmpty()) {
            return "No Clients Found!";
        }
        return clients;
    }

    public Object getClientById(int id) {
      Optional<Clients> client = clientRepository.findById(id);

      if (!client.isPresent()) {
          return "No Client Found with this is id "+id;
      }
      return client.get();
    }

    public Object saveClient(Clients client){
        return clientRepository.save(client);
    }

    public Object updateClient(Clients newClient, int id) {

        return clientRepository.findById(id)
                .map(client -> {
                    client.setFirst_name(newClient.getFirst_name());
                    client.setLast_name(newClient.getLast_name());
                    client.setMiddle_name(newClient.getMiddle_name());
                    client.setSecondary_phone_number(newClient.getSecondary_phone_number());
                    client.setGender(newClient.getGender());
                    client.setDob(newClient.getDob());
                    client.setAddress1_country(newClient.getAddress1_country());
                    client.setAddress1_state(newClient.getAddress1_state());
                    client.setAddress1_city(newClient.getAddress1_city());
                    client.setAddress1_zipcode(newClient.getAddress1_zipcode());
                    client.setAddress1_street_address(newClient.getAddress1_street_address());
                    client.setAddress2_country(newClient.getAddress2_country());
                    client.setAddress2_state(newClient.getAddress2_state());
                    client.setAddress2_city(newClient.getAddress2_city());
                    client.setAddress2_zipcode(newClient.getAddress2_zipcode());
                    client.setAddress2_street_address(newClient.getAddress2_street_address());
                    return clientRepository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return clientRepository.save(newClient);
                });
    }

    public Object deleteClientById(int id) {
        Optional<Clients> client = clientRepository.findById(id);

        if (!client.isPresent()) {
            return "No Client Found with this is id "+id;
        }
        clientRepository.deleteById(id);
        return "Client Deleted Successfully.";
    }
}