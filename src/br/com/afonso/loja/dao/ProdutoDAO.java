package br.com.afonso.loja.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import br.com.afonso.loja.dominio.Produto;
import br.com.afonso.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.ioc.Component;

/**
 * @author afonso.jota@gmail.com (Afonso J. Filgueiras)
 */
@Component
public class ProdutoDAO implements RepositorioDeProdutos {

	private final static List<Produto> PRODUTOS = new ArrayList<Produto>();

	static {
		populaProdutosIniciais();
	}

	public void salva(Produto produto) {
		produto.setId(PRODUTOS.size() + 1l);
		PRODUTOS.add(produto);
	}

	public List<Produto> pegaTodos() {
		return Collections.unmodifiableList(PRODUTOS);
	}

	public void remove(Produto produto) {
		Iterator<Produto> it = PRODUTOS.iterator();
		while (it.hasNext()) {
			Produto existente = it.next();
			if (existente.getId().equals(produto.getId())) {
				it.remove();
				break;
			}
		}
	}

	private static void populaProdutosIniciais() {
		PRODUTOS.add(new Produto(1l, "Motorola", "Smart Phone", "preto", 899.90));
		PRODUTOS.add(new Produto(2l, "MacBook", "Apple", "branco", 1999.99));
		PRODUTOS.add(new Produto(3l, "Ferrari", "perfume", "vermelho", 607.80));
		PRODUTOS.add(new Produto(4l, "Metallica", "dvd ao vivo", "", 40.90));
	}

	public Produto pegaPorId(Long id) {
		for (Produto produto : PRODUTOS) {
			if (produto.getId().equals(id))
				return produto;
		}
		return null;
	}

}
