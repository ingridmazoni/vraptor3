package br.com.caelum.vraptor.Entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Livro")
public class Livro {
	
	@Id @GeneratedValue
	private Long id;
	
	@NotEmpty(message = "{campo.obrigatorio}")
	@Column(unique=true)
	private String isbn;
		
	@NotEmpty(message = "{campo.obrigatorio}")
	@Column(name="titulo")
	private String titulo;
	
	@NotEmpty(message = "{campo.obrigatorio}")
	@Column(name="descricao")
	private String descricao;
	
	@NotNull(message = "{campo.obrigatorio}")
	@DecimalMin("0.0")
	@Column(name="preco")
	private BigDecimal preco;
	
	@Temporal (TemporalType.DATE )
	@Past(message = "{data.passado}")
	@Column(name="dataPublicacao")
	private Calendar dataPublicacao;
		
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
