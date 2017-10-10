/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.Producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author laerton
 */
public class EntityManagerProducer {
    
    private static EntityManager manager = null;
    
    @Produces
    public static EntityManager getEntityManager() {
        manager = Persistence
                .createEntityManagerFactory("br.edu.ifpb_atividade-cdi-jsf-laerton_war_1.0PU")
                .createEntityManager();
        return manager;
    }
    
}