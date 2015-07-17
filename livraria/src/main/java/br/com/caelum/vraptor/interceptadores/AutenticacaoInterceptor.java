package br.com.caelum.vraptor.interceptadores;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.estante.UsuarioLogado;
import br.com.caelum.vraptor.resource.ResourceMethod;

/*@Intercepts
public class AutenticacaoInterceptor implements Interceptor{
		private UsuarioLogado usuario;
		private Result result;
	
	
		public AutenticacaoInterceptor(UsuarioLogado usuario, Result result) {
			this.usuario = usuario;
			this.result = result;
		}
		
		public boolean accepts(ResourceMethod method) {
			return !method.getResource().getType().equals(LoginController.class);
		}
		
		public void intercept(InterceptorStack stack,ResourceMethod method,Object controller) {
				if (usuario.isLogado()) {
					stack.next(method, controller);
				} else {
					result.redirectTo(LoginController.class).formulario();
				}
		}
	}*/