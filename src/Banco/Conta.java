package Banco;
import java.util.Random;

import UsuarioBanco.Correntista;
public abstract class Conta {
	
	private float saldo;
	Correntista Correntista;
	private String NumeroConta;
	
	Conta(Correntista correntista) {
		this.Correntista = correntista;
		setNumeroConta();
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
		System.out.println("Número da Conta: "+ this.gerarNumeroConta());
		System.out.println("Saldo: "+ this.getSaldo());
	}

	public abstract void depositar(float valor);
		
	
	public abstract void retirar(float valor);
	                                                                                     
	public void transferirPara(Conta outraConta, float valor) throws Exception {
		this.retirar(valor);
		outraConta.depositar(valor);
	}
}
