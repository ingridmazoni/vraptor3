package br.com.caelum.vraptor.interceptadores;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.resource.ResourceMethod;


@Intercepts
public class TransacoesInterceptor implements Interceptor{
	
	private EntityManager manager;
	
	
	public TransacoesInterceptor(EntityManager manager) {
		this.manager = manager;
	}
	
	
	public boolean accepts(ResourceMethod method) {
		return method.containsAnnotation(Transacional.class);
	}
	
	public void intercept(InterceptorStack stack,ResourceMethod method,Object controller) throws InterceptionException{
		/*try {*/
			manager.getTransaction().begin();
			stack.next(method, controller);
			manager.getTransaction().commit();
		/*}
		finally {
				if (manager.getTransaction().isActive()) {
						manager.getTransaction().rollback();
				}
		}*/
	}


}


