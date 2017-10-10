/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.servicos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author laerton
 */
public interface Service<T> extends Serializable{
    
    void add(T t);
    List<T> getAll();
    T get(String key);
    
}
