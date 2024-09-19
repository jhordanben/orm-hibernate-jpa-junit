package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({

	@NamedQuery(name = "consultaTodos", query = "select u from UsuarioPessoa u "),
	@NamedQuery(name = "buscarTodos", query = "select u from UsuarioPessoa u where u.nome = :nome")
	
	//@NamedQuery(name = "UsuarioPessoa.deleteAll", query = "delete u from UsuarioPessoa u")
	
})

public class UsuarioPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private int idade;
	
	@OneToMany(mappedBy = "usuarioPessoa", fetch = FetchType.EAGER)
	private List<TelefoneUser> telefoneUsers;
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
	
	
	
	public List<TelefoneUser> getTelefoneUsers() {
		return telefoneUsers;
	}

	public void setTelefoneUsers(List<TelefoneUser> telefoneUsers) {
		this.telefoneUsers = telefoneUsers;
	}

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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", idade=" + idade + "]";
	}
	
	
	

}
