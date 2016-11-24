package br.com.gpmodontosystem.type;

public enum TypeSexo {

	M("M"), F("F");
	
	private String sexo;

	private TypeSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}

	
}
