package com.aplicacao.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.aplicacao.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

/* Aula 27. Essa classe vai ser do tipo abstract para garantir que eu não instancia 
   pagamentos */

/* Aula 27. Fazer o mapeamento de herança vou usar o anotation
   @Inheritance */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/* Nesse caso caso o "Id" não vai receber o 
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   para gerar o "Id" automáticamente, porque ele tem que 
	   ter o mesmo "Id" do pedido correspondente. Faço isso
	   no "private Pedido pedido" */
	@Id
	private Integer id;
	private Integer estado;
	
	/* Uso a anotação @OneToOne porque na regra é um para um.
	   Uso "@JoinColumn(name = "pedido_id")" para identifiar no BD
	   qual é o campo que está mapeando o pedido. 
	   Para garantir que o "Id" desse pagamento seja o mesmo "Id"
	   do "Pedido" uso o anotation "@MapsId"*/
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = (estado==null) ? null : estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
}
