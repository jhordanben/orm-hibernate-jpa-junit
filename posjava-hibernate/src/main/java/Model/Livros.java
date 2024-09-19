package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	
	@NamedQuery(name = "consultarLivro", query = "select u from Livros u")
	
	
}) 

public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //esses codigos sao responsaveis por "publicar" um private string nome
	
	private int id;
	private String nome;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Livros [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
