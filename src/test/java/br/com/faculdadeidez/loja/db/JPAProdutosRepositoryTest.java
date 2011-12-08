package br.com.faculdadeidez.loja.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.faculdadeidez.loja.Produto;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(
	{ "classpath:/test-application-context.xml" }
		)
public class JPAProdutosRepositoryTest {

	@Autowired
	private ApplicationContext context;	
	
	@Test
	public void testSalvarProduto() {
		ProdutosRepository repositorio = 
				this.context.getBean( 
						"produtosRepository",
						ProdutosRepository.class
						);
		
		Produto p = new Produto();
		p.setNome( "O Poderoso Chefão" );
		p.setDescricao( "Filme sobre máfia" );
		p.setPreco( 50 );
		
		p = repositorio.createOrUpdate(p);
		
		Assert.assertNotNull( p.getId() );
		
	}
	
}
