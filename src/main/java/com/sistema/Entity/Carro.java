package com.sistema.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbCarro", schema = "locadora")
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private Long chassi;
	private Long renavam;
	private BigDecimal valorDiaria;
	private String ano;
	private String cor;
	private Integer porta;
	
	@ManyToOne(fetch = FetchType.LAZY) //EAGER
	@JoinColumn(name = "cod_modelo_carro")
	private ModeloCarro modeloCarro;
	
	@OneToMany(mappedBy = "carro")
	private List<Reserva> reserva;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="carro_opcionais_id"
				, joinColumns=@JoinColumn(name="cod_carro")
				, inverseJoinColumns=@JoinColumn(name="cod_opcionais"))
	private List<Opcionais> opcionais = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getChassi() {
		return chassi;
	}

	public void setChassi(Long chassi) {
		this.chassi = chassi;
	}

	public Long getRenavam() {
		return renavam;
	}

	public void setRenavam(Long renavam) {
		this.renavam = renavam;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public List<Opcionais> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcionais> opcionais) {
		this.opcionais = opcionais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
