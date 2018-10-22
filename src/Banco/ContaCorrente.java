package Banco;

public class ContaCorrente extends Conta{
		
	//construtor
	public ContaCorrente(float saldoInicial) {
		this.setSaldo(saldoInicial);
	}
	
	@Override
	public void retirar(float valor) {
		this.setSaldo(this.getSaldo() - valor);
	}
	
	@Override
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor) ;
	}



}
