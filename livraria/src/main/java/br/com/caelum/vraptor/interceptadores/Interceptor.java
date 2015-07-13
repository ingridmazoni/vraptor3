package br.com.caelum.vraptor.interceptadores;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.resource.ResourceMethod;

public interface Interceptor {
	public boolean accepts(ResourceMethod method);
	public void intercept(InterceptorStack stack,ResourceMethod method,Object controller) throws InterceptionException;

}
