package br.com.afonso.loja.repositorio;

import java.util.List;

import br.com.afonso.loja.dominio.Produto;

public interface RepositorioDeProdutos {

	void salva(Produto produto);
	List<Produto> pegaTodos();
	void remove(Produto produto);
	Produto pegaPorId(Long id);
}
