package br.com.afonso.loja.controlador;

import br.com.afonso.loja.dominio.UsuarioLogado;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * @author afonso.jota@gmail.com (Afonso J. Filgueiras)
 */
@Resource
public class UsuarioController {

	private final UsuarioLogado usuario;
	private final Result result;

	public UsuarioController(UsuarioLogado usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}

	public void loga() {
		usuario.setLogin("Afonso");
	}

	public void exibe() {
		result.include("usuario", usuario.getLogin());
	}

}
