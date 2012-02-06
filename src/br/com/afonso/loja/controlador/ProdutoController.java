package br.com.afonso.loja.controlador;

import java.util.List;

import br.com.afonso.loja.dominio.Produto;
import br.com.afonso.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

/**
 * @author afonso.jota@gmail.com (Afonso J. Filgueiras)
 */
@Resource
public class ProdutoController {

	private final RepositorioDeProdutos produtos;
	private final Result result;
	private final Validator validator;

	public ProdutoController(RepositorioDeProdutos produtos, Result result,
			Validator validator) {
		this.produtos = produtos;
		this.result = result;
		this.validator = validator;
	}

	public List<Produto> lista() {
		return produtos.pegaTodos();
	}

	@Path("/produto/{id}")
	public Produto exibe(Long id) {
		return produtos.pegaPorId(id);
	}

	public void formulario() {
	}

	@Post
	public void adiciona(final Produto produto) {
		validator.checking(new Validations() {
			{
				that(produto.getPreco() >= 0, "Erro", "produto.preco.invalido");
				that(produto.getDescricao() != "", "Erro",
						"produto.descricao.invalido");
				that(produto.getDescricao().length() >= 3
						&& produto.getDescricao().length() <= 100, "Erro",
						"produto.descricao.tamanho");
			}
		});
		validator.onErrorUsePageOf(this).formulario();
		produtos.salva(produto);
		result.redirectTo(this).lista();
	}

	public void remove(Produto produto) {
		produtos.remove(produto);
		result.nothing();
	}

}
