/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.persistencia;

import br.edu.ifpb.atividade.cdi.jsf.modelo.Produto;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author laerton
 */
public class ProdutoRepository implements Repository<Produto>{
     @Inject
    private EntityManager manager;

    @Override
    public void save(Produto produto) {
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();
    }

    @Override
    public List<Produto> list() {
        return manager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    @Override
    public Produto get(String key) {
        return null;
    }
}
