package br.com.caelum.vraptor.daoImplementation;

import javax.persistence.EntityManager;

public interface ComponenteFactory{
	
	public EntityManager getInstance();

}
