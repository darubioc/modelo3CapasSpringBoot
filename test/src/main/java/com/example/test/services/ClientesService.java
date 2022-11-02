package com.example.test.services;

import com.example.test.entities.Clientes;
import com.example.test.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientesService implements BaseService<Clientes> {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    @Transactional
    public List<Clientes> findAll() throws Exception {
        try{
            List<Clientes> clientes = clientesRepository.findAll();
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Clientes findById(Long id) throws Exception {
        try{
            Optional<Clientes> entityOptional = clientesRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Clientes save(Clientes entity) throws Exception {
        try{
            entity = clientesRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Clientes update(Long id, Clientes entity) throws Exception {
        try{
            Optional<Clientes> entityOptional =clientesRepository.findById(id);
            Clientes cliente = entityOptional.get();
            cliente = clientesRepository.save(entity);
            return cliente;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(clientesRepository.existsById(id)){
                clientesRepository.deleteById(id);
                return true;
            } else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
