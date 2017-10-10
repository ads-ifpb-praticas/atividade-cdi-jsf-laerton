/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.servicos;

import br.edu.ifpb.atividade.cdi.jsf.modelo.Categoria;
import br.edu.ifpb.atividade.cdi.jsf.persistencia.Repository;
import br.edu.ifpb.atividade.cdi.jsf.qualificadores.CategoriaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author laerton
 */
public class CategoriaService implements Service<Categoria>{
    @Inject
    @CategoriaPersistence
    private Repository<Categoria> repository;

    public CategoriaService() {
    }

    @Override
    public void add(Categoria categoria) {
        repository.save(categoria);
    }
    
    @Override
    public List<Categoria> getAll() {
        return repository.list();
    }

    @Override
    public Categoria get(String name) {
        return repository.get(name);
    }
}
