package br.com.caelum.vraptor.daoImplementation;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;


@Component
public class FabricaDeEntityManager implements ComponentFactory<EntityManager>{
	EntityManager manager;
	
	

	public FabricaDeEntityManager(EntityManagerFactory factory) {
		this.manager = factory.createEntityManager();
		}

	
	public EntityManager getInstance() {
		return manager;
	}


}
