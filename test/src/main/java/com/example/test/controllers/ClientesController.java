package com.example.test.controllers;

import com.example.test.entities.Clientes;
import com.example.test.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientesService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientesService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego.\"}");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Clientes entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientesService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego.\""+e+"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> save(@PathVariable Long id,@RequestBody Clientes entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientesService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        System.out.println("id obtenida => "+id);
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientesService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego.\""+e+"}");
        }
    }
}
