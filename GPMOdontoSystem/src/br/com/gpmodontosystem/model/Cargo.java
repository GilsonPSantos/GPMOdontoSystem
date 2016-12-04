package br.com.gpmodontosystem.model;

public class Cargo {
	
	private Integer idCargo;
	private String nomeCargo;
	
	public Cargo() {
	}
	
	/**
	 * @param idCargo
	 * @param nomeCargo
	 */
	public Cargo(Integer idCargo, String nomeCargo) {
		super();
		this.idCargo = idCargo;
		this.nomeCargo = nomeCargo;
	}
	
	public Integer getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	
	

}
