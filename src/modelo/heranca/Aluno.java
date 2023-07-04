package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//InheritanceType.TABLE_PER_CLASS => será criada uma tabela para cada classe, onde a tabela que 
//representa a classe herdada (filha) tem os atributos da classe pai

//Se o @Inheritance não for informado, será aplicado uma orma paracida com o SINGLE_TABLE onde uma unica tabela será criada com todos os atributos pai e filhos

//InheritanceType.SINGLE_TABLE => será criada uma unica tabela, porém com o auxilio do @DiscriminatorColumn e @DiscriminatorValue é possivel criar uma coluna que irá identificar o tipo do registro no banco de dados

//InheritanceType.JOINED => será criada duas tabelas, o discriminator continua funcionando, criando a coluna tipo na tabela principal, e será criada uma tabela para a classe filha, com um relacionamento 1:1 para a tabela pai

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL")
public class Aluno {

	@Id
	private Long matricula;
	
	private String nome;
	
	public Aluno() {
		
	}
	
	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
