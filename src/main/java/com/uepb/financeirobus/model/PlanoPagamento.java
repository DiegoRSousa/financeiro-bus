package com.uepb.financeirobus.model;

public enum PlanoPagamento {


	PARCIAL("Parcial"),
	INTEGRAL("Integral");
	
	private String descricao;

	PlanoPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
