package br.com.afonso.loja.dominio;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author afonso.jota@gmail.com (Afonso J. Filgueiras)
 */
@Component
@SessionScoped
public class UsuarioLogado {

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
