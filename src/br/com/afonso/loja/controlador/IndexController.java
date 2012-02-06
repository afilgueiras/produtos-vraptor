package br.com.afonso.loja.controlador;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

/**
 * @author afonso.jota@gmail.com (Afonso J. Filgueiras)
 */
@Resource
public class IndexController {

	@Path("/")
	public void root() {
		System.out.println("Meu sistema com vraptor");
	}

	@Path("/ajuda")
	public void ajuda() {
		System.out.println("O método de ajuda foi invocado");
	}

	@Path("/contato")
	public void contato() {
		System.out.println("O método contato foi invocado");
	}

}
