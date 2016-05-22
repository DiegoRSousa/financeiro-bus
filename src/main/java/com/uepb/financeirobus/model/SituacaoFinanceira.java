package com.uepb.financeirobus.model;

public enum SituacaoFinanceira {

	EM_DIA("Em dia"),
	ATRASADO("Atrasado");
	
	private String descricao;
	
	SituacaoFinanceira(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
