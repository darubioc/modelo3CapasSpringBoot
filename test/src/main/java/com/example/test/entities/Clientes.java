package com.example.test.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "Clientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Clientes implements Serializable {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APELLIDO")
    private String apellido;

    @Column(name="EMAIL")
    private String email;

    @Column(name="CREATEAT")
    private Date CreateAt;
}

