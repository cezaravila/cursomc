package com.aplicacao.cursomc.domain;

import javax.persistence.Entity;

import com.aplicacao.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
	}

	/*
	 Como essa classe é uma subpasta na hora de gerar o construtor
	 com argumentos escolho essa opção a baixo
	 "Generate Constructors from Superclass"
	  E Add nele o Integer no construtor
	  */
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	

}
