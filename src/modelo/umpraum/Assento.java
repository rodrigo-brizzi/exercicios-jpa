package modelo.umpraum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.basico.Entidade;

@Entity
@Table(name = "assentos")
public class Assento implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	//Essa é a segunda parte da relaçção bidirecional
	//Dentro da classe Cliente o atributo assento mapeia a relaçao 1:1
	//A relação 1:1 está mapeada pelo atributo assento dentro da classe Cliente
	@OneToOne(mappedBy = "assento")
	private Cliente cliente;
	
	public Assento() {
		
	}

	public Assento(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}