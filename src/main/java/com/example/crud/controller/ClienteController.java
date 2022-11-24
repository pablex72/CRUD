package com.example.crud.controller;

import com.example.crud.entity.Cliente;
import com.example.crud.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Cliente> list(){
        return service.list();
    }

    @GetMapping("/{id}")
    public Cliente find (@PathVariable("id") int id){
        return service.find(id);
    }

    @PostMapping
    public Cliente create (@RequestBody Cliente cliente){
        return service.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable("id") int id, @RequestBody Cliente cliente){
        return service.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
