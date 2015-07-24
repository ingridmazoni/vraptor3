package br.com.caelum.vraptor.interceptadores;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.repository.RegistroDeUsuarios;
import br.com.caelum.vraptor.resource.ResourceMethod;

/*@Intercepts
public class AutenticacaoInterceptor implements Interceptor{
		private RegistroDeUsuarios usuarios;
		private Result result;
	
	
		public AutenticacaoInterceptor(RegistroDeUsuarios usuarios, Result result) {
			this.usuarios = usuarios;
			this.result = result;
		}
		
		public boolean accepts(ResourceMethod method) {
			return !method.getResource().getType().equals(LoginController.class);
		}
		
		public void intercept(InterceptorStack stack,ResourceMethod method,Object controller) {
				if (usuarios.isLogado()) {
					stack.next(method, controller);
				} else {
					result.redirectTo(LoginController.class).formulario();
				}
		}
	}*/