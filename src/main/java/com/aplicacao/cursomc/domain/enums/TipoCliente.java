package com.aplicacao.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	// O construtor do tipo enum é sempre priveite
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// para o tipo enum criamos apenas o get
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	/* vai ser do tipo statica, para ser esecutada mesmo sem ser
	   instanciado objeto */
	public static TipoCliente toEnum(Integer cod) {
		/*para devolver o tipo cliente atravez de um código 
		  vou fazer uma busca*/ 
		if(cod == null) {
			return null;
		}
		
		/* Vou fazer uma busca em todo os valores do TipoCliente enum */
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw  new IllegalArgumentException("Id inválido: " + cod);
	}
}
