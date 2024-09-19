package posjava_hibernate.posjava_hibernate;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import Model.Livros;
import Model.TelefoneUser;
import Model.UsuarioPessoa;
import dao.DaoGeneric;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() { // SALVAR UM DADO NA TABELA
		DaoGeneric<Livros> daoGeneric = new DaoGeneric<Livros>();
		
		Livros livros = new Livros();
		
		livros.setNome("pai rico pai pobre");
		
		daoGeneric.salvar(livros);
		
	}
	
	@Test
	public void testeBuscar() {
		DaoGeneric<Livros> daoGeneric = new DaoGeneric<Livros>();
		Livros livros = new Livros();
		livros.setId(15);
		
		livros = daoGeneric.pesquisar(livros);
		
		System.out.println(livros);
		
	}
	
	@Test
	public void testeBuscar2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3, UsuarioPessoa.class);
		
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(5, UsuarioPessoa.class);
		
		pessoa.setIdade(22);
		pessoa.setNome("everything has changed");
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeDeletar() {
		DaoGeneric<Livros> daoGeneric = new DaoGeneric<Livros>();
		
		Livros livros = daoGeneric.pesquisar(16, Livros.class);
		
		daoGeneric.deletarPorId(livros);
		
	}
	
	@Test
	public void testeConsultar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
			System.out.println("--------------------------------------------");
			
		}
	}
	
	@Test
	public void testeQueryList() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQueryListMaxResult() {
		
		DaoGeneric<Livros> daoGeneric = new DaoGeneric<Livros>();
		
		List<Livros> list = daoGeneric.getEntityManager().createQuery(" from Livros order by id")
				.setMaxResults(10).getResultList(); //escolhe do menor para o maior e pode escolher nome, id oq quiser
		
		for (Livros livros : list) {
			System.out.println(livros);
		}
	}
	
	@Test
	public void testeQueryListParameter() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa where nome = :nome")
				.setParameter("nome", "everythinghaschanged").getResultList(); //escolhe do menor para o maior e pode escolher nome, id oq quiser
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQuerySomaIdade() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		Long somaIdade = (Long) daoGeneric.getEntityManager()
				.createQuery("select sum(u.idade) from UsuarioPessoa u ").getSingleResult();
		
		System.out.println("a soma de todas as idades é ->" + somaIdade);
	}
	
	@Test
	public void testeQueryDivisaoIdade() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		Double divisaoIdade = (Double) daoGeneric.getEntityManager()
				.createQuery("select avg(u.idade) from UsuarioPessoa u ").getSingleResult();
		
		System.out.println("a divisao de todas as idades é ->" + divisaoIdade);
	}
	
	@Test
	public void testeNamedQuery1() {
		
		DaoGeneric <UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List <UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("consultaTodos").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeNamedQuery2() {
		
		DaoGeneric <UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List <UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("buscarTodos")
				.setParameter("nome", "willow").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeGravaTelefone() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(2, UsuarioPessoa.class);
		
		TelefoneUser telefoneUser = new TelefoneUser();
		
		telefoneUser.setTipo("Celular");
		telefoneUser.setNumero("11945551757");
		telefoneUser.setUsuarioPessoa(pessoa);
		
		daoGeneric.salvar(telefoneUser);
		
	}
	
	@Test
	public void testeConsultaTelefone() {
		
		DaoGeneric daoGeneric = new DaoGeneric();
		
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(2, UsuarioPessoa.class);
		
		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			System.out.println(fone.getNumero());
			System.out.println(fone.getTipo());
			System.out.println(fone.getUsuarioPessoa().getNome());
			System.out.println("--------------------------------------------------------");
			
			
		}
		
	}

}
