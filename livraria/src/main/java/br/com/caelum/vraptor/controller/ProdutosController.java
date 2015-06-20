package br.com.caelum.vraptor.controller;


import java.util.List;

import javax.annotation.Resource;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.entity.*;
import br.com.caelum.vraptor.dao.*;

@Resource
public class ProdutosController {
	
	 private ProdutoDao dao;
	 private Result result;
	 
	 public ProdutosController(ProdutoDao dao, Result result) {
	        this.dao = dao;
	        this.result = result;
	    }
	 
	 public void form() {
	    
	 }

	
	public List<Produto> lista() {
        return dao.listaTodos();
        
	}
	
	
	 public void adiciona(Produto produto) {
	        dao.adiciona(produto);
	        result.redirectTo(ProdutosController.class).lista();

	    }

}
