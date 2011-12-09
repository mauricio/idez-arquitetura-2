package br.com.faculdadeidez.loja.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import br.com.faculdadeidez.loja.Produto;

public class AdicionarProdutoMain {

	public static void main( String[] args ) throws Exception {
		
		ApplicationContext c = new FileSystemXmlApplicationContext( "src/main/webapp/WEB-INF/application-context.xml" );
		
		ProdutosRepository r = c.getBean( ProdutosRepository.class );
		
		Produto p = new Produto();
		p.setNome("meu nome");
		
		r.createOrUpdate(p);
	}
	
}
