package com.example.web1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseEntity {
//Atributos
    @Id // estabelece atributo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // estabelece a chave primária como auto incremental
    @Basic(optional = false) // define que o atributo é obrigatório
    private Long id;

    @CreationTimestamp // estabelece o timestamp só na criação
    private Timestamp createdAt;

    @UpdateTimestamp // estabelece novo timestamp sempre que for atualizado
    private Timestamp modifiedAt;

//Construtores
    public BaseEntity(){}
    public BaseEntity(Long id){
        this.id=id;
    }

//Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
