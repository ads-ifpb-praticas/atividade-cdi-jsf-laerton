/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.modelo;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author laerton
 */

@Entity
@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq")
public class Produto implements  Serializable{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 50, nullable = false, unique = true)
    private String nome;
    @Column(columnDefinition = "VARCHAR")
    private String pathPhoto;
    @Column(length = 150, nullable = false)
    private String descricao;
    @Column(columnDefinition = "NUMERIC(7,2) DEFAULT 0", nullable = false)
    private double unitario;
    @Column(length = 30, nullable = false)
    private String marca;
    
    @OneToOne
    @Inject
    private Categoria categoria;
    
    public Produto() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getUnitario() {
        return unitario;
    }

    public void setUnitario(double unitario) {
        this.unitario = unitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    
    
    
}
