package com.juntaapp.controller;

import com.juntaapp.exception.ResourceNotFoundException;
import com.juntaapp.model.Cliente;
import com.juntaapp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllClients() {
        return clienteRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable  long id){
        Cliente employee = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Cliente> updateEmployee(@PathVariable long id,@RequestBody Cliente clienteDetails) {
        Cliente updateCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateCliente.setUsuario(clienteDetails.getUsuario());
        updateCliente.setCi(clienteDetails.getCi());

        clienteRepository.save(updateCliente);

        return ResponseEntity.ok(updateCliente);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable long id){

        Cliente employee = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        clienteRepository   .delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
