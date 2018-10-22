package Banco;

public class ContaPoupanca extends Conta {
	//construtor
	public ContaPoupanca(float saldoInicial) {
		this.setSaldo(saldoInicial);
	}
	
	
	@Override
	public void retirar(float valor) {
		this.setSaldo(this.getSaldo() - valor);
	}
	
	@Override
	public void depositar(float valor) {
		this.setSaldo( this.getSaldo() + (valor* 1.01f));
	}
}
