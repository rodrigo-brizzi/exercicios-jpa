package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.basico.Entidade;

@Entity
@Table(name = "clientes")
public class Cliente implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	//Essa é a primeira parte da relação bidirecinal onde de fato tem o atributo que mapeia a relação e será criado na tabela como chave estrangeira
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "assento_id", unique = true)
	private Assento assento;
	
	public Cliente() {
		
	}

	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
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

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
}
