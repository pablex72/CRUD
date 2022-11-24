package com.example.crud.service;

import com.example.crud.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    //listado clientes

    private List<Cliente> clientes;

    public ClienteService(){
        clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan", "Paredes", "1111"));
        clientes.add(new Cliente(2, "Luis", "Raldes", "2222"));
        clientes.add(new Cliente(3, "Pepe", "Flores", "3333"));
    }

    public List<Cliente> list(){
        return clientes;
    }

    //Buscar Cliente
    public Cliente find(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
    //Crear Cliente
    public Cliente save(Cliente cli){
        clientes.add(cli);
        return cli;
    }

    //actualizar Cliente
    public Cliente update(int id, Cliente cli){
        int index = 0;
        for (Cliente l: clientes){
            if(l.getId() == id){
                cli.setId(id);
                clientes.set(index, cli);
            }
        }
        return cli;
    }

    //Eliminar Cliente
    public boolean delete(int id){
        for (Cliente c:clientes) {
            if(c.getId() == id){
                return clientes.remove(c);
            }
        }
        return false;
    }
}
