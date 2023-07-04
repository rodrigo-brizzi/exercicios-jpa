package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Qualquer mudança feita no objeto dentro de um contexto transacional
		//será refletida no banco pois, por padrão o objeto está no estado gerenciado
		//onde tudo o que for alterado nele neste estado será refletido no banco de dados
		
		Usuario usuario = em.find(Usuario.class, 3L);
		usuario.setNome("Rodrigo");
		//usuario.setEmail("rodrigo_brizzi@lanche.com.br");
		
		//em.merge(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}
