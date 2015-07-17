package br.com.caelum.vraptor.interceptadores;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.estante.UsuarioLogado;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;

/*@Intercepts(after=AutorizacaoInterceptor.class)
	public class AutorizacaoInterceptor implements Interceptor{
	private UsuarioLogado usuario;
	private Result result;
	
	public AutorizacaoInterceptor(UsuarioLogado usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}
	public boolean accepts(ResourceMethod method) {
			return !method.getResource().getType().equals(LoginController.class);
	}
		
	public void intercept(InterceptorStack stack,ResourceMethod method,Object controller) {
			if (podeAcessar(method)) {
				stack.next(method, controller);
			} else {
				result.use(Results.http()).sendError(401,"Você não está autorizado!");
			}
	}
	
	private boolean podeAcessar(ResourceMethod method) {
		return method.containsAnnotation(Get.class) || usuario.getUsuario().isAdmin();
	}
}*/