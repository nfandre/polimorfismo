import java.util.Scanner;

import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaInvestimento;
import Banco.ContaPoupanca;
import UsuarioBanco.Correntista;

public class App {

	public static void main(String[] args) throws Exception {
		

		/*
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
		System.out.println("Saldo Investimento: "+ci.getSaldo()); */
		
		
		Scanner ler = new Scanner(System.in);
		int escolha = 0;
		while(escolha != 4) {
			System.out.println("\nBanco asosAbc");
			
			System.out.println("1 - Criar: ");
			System.out.println("2 - Consultar: ");
			System.out.println("3 - Alterar: ");
			System.out.println("4 - Sair");
			escolha = Integer.parseInt(ler.next());	
			
			if(escolha == 1) {
				System.out.println("Cadastro do correntista: ");
				Correntista correntista = new Correntista();
				System.out.print("Nome: ");
				correntista.setNome(ler.next());
				System.out.print("CPF: ");
				correntista.setCpf(ler.next());
				
				System.out.println("Tipo de conta a ser criada: ");
				System.out.println("1 - Conta Corrente \n2 - Conta Corrente \n3 - Conta Poupança");
				escolha = Integer.parseInt(ler.next());
				if(escolha == 1) {
					Conta cc = new ContaCorrente(correntista, 0);
					System.out.println("Deseja realizar depósito? \n1- Sim \n2 - Não ");
					escolha = Integer.parseInt(ler.next());
					
					if(escolha == 1) {
						System.out.println("Valor do depósito: ");
						float valor = ler.nextFloat();
						cc.depositar(valor);
						System.out.println("Depósito realisado :) ");
						cc.exibirConta();
					}
				}
				if(escolha == 2) {
					Conta ci = new ContaInvestimento(correntista, 0);
					System.out.println("Deseja realizar depósito? \n1- Sim \n2 - Não ");
					escolha = Integer.parseInt(ler.next());
					if(escolha == 1) {
						System.out.println("Valor do depósito: ");
						float valor = ler.nextFloat();
						ci.depositar(valor);
						System.out.println("Depósito realisado :) ");
						ci.exibirConta();
					}
				}
				if(escolha == 3) {
					Conta cp = new ContaInvestimento(correntista, 0);
					System.out.println("Deseja realizar depósito? \n1- Sim \n2 - Não ");
					escolha = Integer.parseInt(ler.next());
					if(escolha == 1) {
						System.out.println("Valor do depósito: ");
						float valor = ler.nextFloat();
						cp.depositar(valor);
						System.out.println("Depósito realisado :) ");
						cp.exibirConta();
					}
				}
				
			}
			
			
		}
		
			
		
	}
	
	
	public static void exibirSaldo(Conta cc, Conta cp, Conta ci) {
		System.out.println("Poupança: " + cc.getSaldo());
		System.out.println("Corrente: " + cp.getSaldo());
		System.out.println("Investimento: " + ci.getSaldo() );
	}

}
