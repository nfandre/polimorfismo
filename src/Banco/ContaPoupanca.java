package Banco;

public class ContaPoupanca extends Conta {
	//construtor
	public ContaPoupanca(UsuarioBanco.Correntista correntista,float saldoInicial) {
		super(correntista);
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
