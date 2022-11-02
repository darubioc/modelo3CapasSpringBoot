package com.example.test.repositories;

import com.example.test.entities.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes,Long> {
    //Separa por completo la logica d enegocio de la lógica para acceder a la bd


}
