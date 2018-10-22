import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaInvestimento;
import Banco.ContaPoupanca;

public class App {

	public static void main(String[] args) throws Exception {
		
		Conta cc = new ContaCorrente(1000);
		Conta cp = new ContaPoupanca(1000);
		Conta ci = new ContaInvestimento(1000);		
		System.out.println("--------- Saldo Inicial ----------");
		exibirSaldo(cc,cp,ci);
		

		cc.depositar(100);
		cp.depositar(100);
		ci.depositar(100);	
		System.out.println("\n------- Saldo após depósito ------");
		exibirSaldo(cc,cp,ci);


		cp.retirar(100);
		cc.retirar(100);
		ci.retirar(100);		
		System.out.println("\n-------- Saldo após retirar ------");
		exibirSaldo(cc,cp,ci);
		
		cp.transferirPara(ci, 100);
		ci.transferirPara(cc, 50);
		cc.transferirPara(cp, 200);
		System.out.println("\n-------- Saldo após transferência----");
		exibirSaldo(cc,cp,ci);
		
		System.out.println("\nSaldo da conta investimento após render duas vezes");
		((ContaInvestimento)ci).render();
		((ContaInvestimento)ci).render();
		System.out.println("Saldo Investimento: "+ci.getSaldo());
	}
	
	
	public static void exibirSaldo(Conta cc, Conta cp, Conta ci) {
		System.out.println("Poupança: " + cc.getSaldo());
		System.out.println("Corrente: " + cp.getSaldo());
		System.out.println("Investimento: " + ci.getSaldo() );
	}

}
