package br.com.viajemais.model;

import java.sql.Date;

public class Compra {
	private int id_compra;
	public int getId_compra() {
		return id_compra;
	}
	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}
	private int Id_cliente;
	private int id_destinos;
	private String dataEmbarque;
	private String dataRetorno;
	private Date dataCompra;
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public int getId_cliente() {
		return Id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		Id_cliente = id_cliente;
	}
	public int getId_destinos() {
		return id_destinos;
	}
	public void setId_destinos(int id_destinos) {
		this.id_destinos = id_destinos;
	}
	public String getDataEmbarque() {
		return dataEmbarque;
	}
	public void setDataEmbarque(String dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}
	public String getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

}
