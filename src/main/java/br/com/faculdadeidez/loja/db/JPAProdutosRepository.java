package br.com.faculdadeidez.loja.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.faculdadeidez.loja.Produto;

@Repository
public class JPAProdutosRepository 
	implements ProdutosRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Produto> getAll() {

		return this.manager.createQuery( 
				"SELECT p FROM Produto p" , 
				Produto.class)
				.getResultList();
		
	}

	@Override
	@Transactional
	public Produto createOrUpdate(Produto p) {
		return this.manager.merge(p);
	}

}
