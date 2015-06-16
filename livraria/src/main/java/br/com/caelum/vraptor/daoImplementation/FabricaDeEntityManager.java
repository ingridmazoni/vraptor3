package br.com.caelum.vraptor.daoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class FabricaDeEntityManager {
	
	public EntityManager getInstance() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();
		return manager;
		
	}


}
