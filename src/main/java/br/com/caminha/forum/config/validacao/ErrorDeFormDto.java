package br.com.caminha.forum.config.validacao;

public class ErrorDeFormDto {

	private String campo;
	private String erro;
	
	public ErrorDeFormDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
