/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.servicos;

import br.edu.ifpb.atividade.cdi.jsf.modelo.Categoria;
import br.edu.ifpb.atividade.cdi.jsf.modelo.Produto;
import br.edu.ifpb.atividade.cdi.jsf.persistencia.Repository;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author laerton
 */
public class ProdutoService implements Service<Produto> {
    
    @Inject
    private Repository<Produto> repository;

    @Inject
    private CategoriaService service;

    @Override
    public void add(Produto produto) {
        Categoria categoria = service.get(produto.getCategoria().getNome());
        if(categoria != null) {
            produto.setCategoria(categoria);
        } 
        repository.save(produto);
    }

    @Override
    public List<Produto> getAll() {
        return repository.list();
    }
    
    @Override 
    public Produto get(String key) {
        return null;
    }
    
}