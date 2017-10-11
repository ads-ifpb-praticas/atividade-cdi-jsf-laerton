/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.modelo;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author laerton
 */
@Entity
@SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq")
public class Categoria implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column(length = 30, unique = true, nullable = false)
    private String nome;

    public Categoria(String nome) {
        this.nome =nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }

    public Categoria(int id, String nome) {
        this.codigo = id;
        this.nome = nome;
    }
        
}
