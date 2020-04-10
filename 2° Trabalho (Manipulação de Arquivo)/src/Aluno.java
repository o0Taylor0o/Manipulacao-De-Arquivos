public class Aluno {
	private String nome;
	private char[] resposta;
	
	
	public Aluno(String nome, char[] resposta) {
		this.nome = nome;
		this.resposta = resposta;

	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getResposta() {
		String resp = new String(resposta);
		return resp;
	}
	
	public void setResposta(char[] resposta) {
		this.resposta = resposta;
	}
	
	public boolean verficarResposta() {
		char um = resposta[0];
		for(int i = 0; i < resposta.length; i++) {
			if(resposta[i] != um) {
				return false;
			}
		}
		return true;
	}
	
	public int getNota(String gabarito) {
		if(this.verficarResposta()) {
			return 0;
		}else {
		int contador = 0;
		char[] gab = gabarito.toCharArray();
		
		for(int i = 0; i < gab.length; i++) {
			if(this.resposta[i] == gab[i]) {
				contador++;
			}
		}
		return contador;
		}
	}
}