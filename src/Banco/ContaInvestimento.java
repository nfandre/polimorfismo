package Banco;

public class ContaInvestimento extends Conta{
	//construtor
	public ContaInvestimento(UsuarioBanco.Correntista correntista,float valorInicial) {
		super(correntista);
		this.setSaldo(valorInicial);
	}
	
	@Override
	public void retirar(float valor) {
		this.setSaldo(this.getSaldo() - valor);
	}

	@Override
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
		
	}
	public void render() {
		this.setSaldo(this.getSaldo()*1.05f);
	}
}
