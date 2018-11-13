package Banco;
import java.util.Random;

import UsuarioBanco.Correntista;
public abstract class Conta {
	
	private float saldo;
	Correntista Correntista;
	private String NumeroConta;
	
	Conta(Correntista correntista, TipoConta tipoConta) {
		this.Correntista = correntista;
		setNumeroConta();
	}
	
	public Correntista getCorrentista() {
		
		return this.Correntista;
	}

	public void setCorrentista(Correntista correntista) {
		Correntista = correntista;
	}
	
	protected void setSaldo(float valor) {
		this.saldo = valor;

	}
	public String verificarExistencia(Correntista correntista) {
		 return "nExiste";
	}
	
	public String getNumeroConta() {
		return this.NumeroConta;
	}
	public void setNumeroConta() {
		this.NumeroConta = gerarNumeroConta();
	}
	public float getSaldo() {
		return this.saldo;
	}
	public String gerarNumeroConta() {
		Random gerador = new Random();
		return ""+ gerador.nextInt();
	}

	public  void exibirSaldo() {
		System.out.println(this.getSaldo());
	}
	public void exibirConta() {
		System.out.println("Correntista: "+ Correntista.getNome());
		System.out.println("CPF: "+ Correntista.getCpf());
		System.out.println("Número da Conta: "+ this.getNumeroConta());
		System.out.println("Saldo: "+ this.getSaldo());
	}

	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor) ;
	}	
	
	public abstract void retirar(float valor);
	                                                                                     
	public void transferirPara(Conta outraConta, float valor) throws Exception {
		this.retirar(valor);
		outraConta.depositar(valor);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		
		boolean resultado = false;
		
		if(obj.getClass() == this.getClass()) {
			
			Conta other = (Conta)obj;
			
			resultado = 
					this.getNumeroConta().equals(other.getNumeroConta());
			resultado = resultado &&
					this.getCorrentista().equals(other.getCorrentista());
		}
		
		return resultado;
	}
}
