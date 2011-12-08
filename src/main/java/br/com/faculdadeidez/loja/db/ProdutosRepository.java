package br.com.faculdadeidez.loja.db;

import java.util.List;

import br.com.faculdadeidez.loja.Produto;

public interface ProdutosRepository {

	public List<Produto> getAll();
	public Produto createOrUpdate( Produto p );	
	
}
