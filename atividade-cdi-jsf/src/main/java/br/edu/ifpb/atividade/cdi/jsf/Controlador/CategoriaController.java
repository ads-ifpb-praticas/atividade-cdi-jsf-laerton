/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.Controlador;

import br.edu.ifpb.atividade.cdi.jsf.modelo.Categoria;
import br.edu.ifpb.atividade.cdi.jsf.servicos.Service;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */
@Named
@RequestScoped
public class CategoriaController implements Serializable {

    @Inject
    private Service<Categoria> service;
    private String nomeCategoria;

    public CategoriaController() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String adicionarCategoria() {
        service.add(new Categoria(nomeCategoria));
        nomeCategoria = "";
        return null;
    }
    
    public List<Categoria> list() {
        return Collections.unmodifiableList(service.getAll());
    }

    public Categoria getCategoriaByName(String name) {
        return service.get(name);
    }
    
}

