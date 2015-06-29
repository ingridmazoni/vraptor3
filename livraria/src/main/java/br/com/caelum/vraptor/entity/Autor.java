package br.com.caelum.vraptor.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Autor")
public class Autor {
		
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
		
	@Column
	@NotEmpty(message = "{campo.obrigatorio}")
	private String nome;
	
	@Column
	@NotNull(message = "{campo.obrigatorio}")
	private Calendar dataNascimento;
	
	@Column
	@NotNull(message = "{campo.obrigatorio}")
	private Integer numeroDeLivros;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "{campo.obrigatorio}")
	private Pais naturalidade;
	
	@ElementCollection
	@ManyToMany
	private List<Livro> livros;
		
	@ManyToOne
	@JoinColumn (name ="livro_id")
	private Livro ultimoLivro;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Integer getNumeroDeLivros() {
		return numeroDeLivros;
	}
	public void setNumeroDeLivros(Integer numeroDeLivros) {
		this.numeroDeLivros = numeroDeLivros;
	}
	public Pais getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(Pais naturalidade) {
		this.naturalidade = naturalidade;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public Livro getUltimoLivro() {
		return ultimoLivro;
	}
	public void setUltimoLivro(Livro ultimoLivro) {
		this.ultimoLivro = ultimoLivro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	

}
