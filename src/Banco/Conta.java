package Banco;

public abstract class Conta {
	
	private float saldo;
	

	
	protected void setSaldo(float valor) {
		this.saldo = valor;
	}
	
	public float getSaldo() {
		return this.saldo;
	}

	public  void exibirSaldo() {
		System.out.println(this.getSaldo());
	}
	
	
	public abstract void depositar(float valor);
		
	
	public abstract void retirar(float valor);
	                                                                                     
	public void transferirPara(Conta outraConta, float valor) throws Exception {
		this.retirar(valor);
		outraConta.depositar(valor);
	}
}
