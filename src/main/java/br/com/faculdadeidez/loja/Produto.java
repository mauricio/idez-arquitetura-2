package br.com.faculdadeidez.loja;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto extends Entidade {

	private String nome;
	private String descricao;
	private double preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
