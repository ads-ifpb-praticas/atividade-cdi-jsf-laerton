/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.atividade.cdi.jsf.Controlador;

import br.edu.ifpb.atividade.cdi.jsf.modelo.Categoria;
import br.edu.ifpb.atividade.cdi.jsf.modelo.Produto;
import br.edu.ifpb.atividade.cdi.jsf.servicos.GerenciadorFotos;
import br.edu.ifpb.atividade.cdi.jsf.servicos.Service;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author laerton
 */
@Named
@RequestScoped
public class ProdutoController {
    
    private Part foto;
    @Inject
    private Service<Produto> service;
    @Inject
    private Service<Categoria> categoriaService;
    @Inject
    private Produto produto;

    public String adicionarProduto() throws IOException {
        Categoria categoria = categoriaService.get(produto.getCategoria().getNome());
        if (categoria == null) {
            categoriaService.add(produto.getCategoria());
        }
        produto.setPathPhoto(GerenciadorFotos.encodeFoto(foto));
        service.add(produto);
        produto = new Produto();
        return null;
    }
    
    public List<Produto> list() {
        return service.getAll();
    }
    
    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
    }
    
    public Service<Produto> getService() {
        return service;
    }

    public void setService(Service<Produto> service) {
        this.service = service;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}