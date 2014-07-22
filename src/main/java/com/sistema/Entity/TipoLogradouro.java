package com.sistema.Entity;

public enum TipoLogradouro {
	
	AVENIDA("Avenida"),
	RUA("Rua"),
	TRAVESSA("Travessa"),
	BECO("Beco");
	
	private String descricao;
	
	TipoLogradouro(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
