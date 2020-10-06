package br.com.loginSeguro.enums;

public enum PerfilEnum {

	ADMIN("ADMIN", "ADMIN"),
	GESTOR("GESTOR", "GESTOR");
	
	private String chave;
	private String descricao;
	
	private PerfilEnum(String chave, String descricao) {
		this.chave = chave;
		this.descricao = descricao;
	}
	
	public String getChave() {
		return chave;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
