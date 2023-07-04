package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		em.detach(usuario); //remove o objeto do estado gerenciado
		
		usuario.setNome("Rodrigo");
		em.merge(usuario); //necessário chamar para aplicar as alterações no banco quando o objeto não está no estado gerenciado
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}
