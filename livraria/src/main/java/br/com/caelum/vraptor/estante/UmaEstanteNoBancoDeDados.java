package br.com.caelum.vraptor.estante;

import java.util.List;

import javax.annotation.Resource;

import br.com.caelum.vraptor.dao.*;
import br.com.caelum.vraptor.entity.*;
import br.com.caelum.vraptor.repository.*;

@Resource
public class UmaEstanteNoBancoDeDados implements Estante{
	
	private final LivroDao dao;
	
	public UmaEstanteNoBancoDeDados(LivroDao dao) {
			this.dao = dao;
	}

	public void guarda(Livro livro) {
		// TODO Auto-generated method stub
		
	}

	public List<Livro> todosOsLivros() {
		// TODO Auto-generated method stub
		return null;
	}

	public Livro buscaPorIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
