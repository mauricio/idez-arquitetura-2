package br.com.faculdadeidez.loja.resources;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.faculdadeidez.loja.Produto;
import br.com.faculdadeidez.loja.db.ProdutosRepository;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class ProdutosResource {

	@Autowired
	private ProdutosRepository repository;
	
	@GET
	public List<Produto> getAll() {
		return this.repository.getAll();
	}
	
	@POST
	public Produto create( 
		@FormParam("nome") String nome,
		@FormParam("descricao") String descricao,
		@FormParam("preco") double preco			
			) {
		
		Produto p = new Produto();
		p.setNome( nome );
		p.setDescricao( descricao );
		p.setPreco( preco );
		
		return this.repository.createOrUpdate(p);
	}
	
}
