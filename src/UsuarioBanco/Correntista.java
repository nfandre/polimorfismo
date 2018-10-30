package UsuarioBanco;

public class Correntista {
	private String nome;
	private String cpf;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if(obj.getClass() == this.getClass()) {
			
			Correntista other = (Correntista)obj;			
			resultado = 
					this.getCpf().equals(other.getCpf());
		}
		
		return resultado;
	}
}
