/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.persistencia;

import br.edu.ifpb.atividade.cdi.jsf.modelo.Categoria;
import br.edu.ifpb.atividade.cdi.jsf.qualificadores.CategoriaPersistence;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author laerton
 */

@CategoriaPersistence
public class CategoriaRepository implements Repository<Categoria>{
    @Inject
    private EntityManager manager;

    @Override
    public void save(Categoria categoria) {
        manager.getTransaction().begin();
        manager.persist(categoria);
        manager.getTransaction().commit();
    }
    
    @Override
    public List<Categoria> list() {
        return manager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria get(String key) {
        return manager
        .createQuery("SELECT c FROM Categoria c WHERE UPPER(c.nome) = UPPER(:nome)", Categoria.class)
        .setParameter("nome", key)
        .getSingleResult();
    }

}
