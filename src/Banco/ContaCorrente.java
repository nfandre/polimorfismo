package Banco;

public class ContaCorrente extends Conta{
		
	public ContaCorrente(UsuarioBanco.Correntista correntista,float saldoInicial) {	
		super(correntista, TipoConta.Corrente);
		this.setSaldo(saldoInicial);
	}
	
	@Override
	public void retirar(float valor) {
		this.setSaldo(this.getSaldo() - valor);
	}
	


}
