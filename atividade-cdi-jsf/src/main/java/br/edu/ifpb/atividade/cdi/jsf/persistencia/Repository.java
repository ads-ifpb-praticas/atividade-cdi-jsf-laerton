/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.persistencia;

import java.util.List;

/**
 *
 * @author laerton
 */
public interface Repository<T> 
{
    
    void save(T t);
    T get(String key);
    List<T> list();
    
}
