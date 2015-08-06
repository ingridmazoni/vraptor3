package br.com.caelum.vraptor.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.entity.Moeda;

public class Dinheiro {
		
	@Enumerated(EnumType.STRING)
	private Moeda moeda;
	
	@Column
	private BigDecimal montante;
	
	public Dinheiro(){
		
	}
	
	
	public Dinheiro(Moeda moeda, BigDecimal montante) {
		this.moeda = moeda;
		this.montante = montante;
	}
		
	public Moeda getMoeda() {
		return moeda;
	}
	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	public BigDecimal getMontante() {
		return montante;
	}
	public void setMontante(BigDecimal montante) {
		this.montante = montante;
	}
	
	@Override
	public String toString() {
		return String.format("%s%s", moeda.getSimbolo(), montante);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moeda == null) ? 0 : moeda.hashCode());
		result = prime * result
				+ ((montante == null) ? 0 : montante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dinheiro other = (Dinheiro) obj;
		if (moeda != other.moeda)
			return false;
		if (montante == null) {
			if (other.montante != null)
				return false;
		} else if (!montante.equals(other.montante))
			return false;
		return true;
	}
	
	

}
