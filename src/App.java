 import java.util.Scanner;

import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaInvestimento;
import Banco.ContaPoupanca;
import Repositorios.ContaRepository;
import Repositorios.CorrentistaRepository;
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
		System.out.println("\n------- Saldo ap�s dep�sito ------");
		exibirSaldo(cc,cp,ci);


		cp.retirar(100);
		cc.retirar(100);
		ci.retirar(100);		
		System.out.println("\n-------- Saldo ap�s retirar ------");
		exibirSaldo(cc,cp,ci);
		
		cp.transferirPara(ci, 100);
		ci.transferirPara(cc, 50);
		cc.transferirPara(cp, 200);
		System.out.println("\n-------- Saldo ap�s transfer�ncia----");
		exibirSaldo(cc,cp,ci);
		
		System.out.println("\nSaldo da conta investimento ap�s render duas vezes");
		((ContaInvestimento)ci).render();
		((ContaInvestimento)ci).render();
		System.out.println("Saldo Investimento: "+ci.getSaldo()); */
		
		CorrentistaRepository correntistaRepository = new CorrentistaRepository();
		ContaRepository  contaRepository = new ContaRepository();
		Conta contaExibir;
		Correntista correntista = new Correntista();

		Scanner ler = new Scanner(System.in);
		int escolha = 0;
		int escolhaInicial = 0;
		float valor;
		String busca = null;
		
		while(escolhaInicial != 4) {
			System.out.println("\nBanco asosAbc");
			
			System.out.println("1 - Criar: ");
			System.out.println("2 - Consultar: ");
			System.out.println("3 - Transferir: ");
			System.out.println("4 - Sair");
			escolhaInicial = Integer.parseInt(ler.next());	
			
			
			// criar
			if(escolhaInicial == 1) {
				System.out.println("Cadastro do correntista: ");
				correntista = new Correntista();
				correntistaRepository.adicionar(correntista);
				System.out.print("Nome: ");
				correntista.setNome(ler.next());
				System.out.print("CPF: ");
				correntista.setCpf(ler.next());
				System.out.println("Tipo de conta a ser criada: ");
				System.out.println("1 - Conta Corrente \n2 - Conta Corrente \n3 - Conta Poupan�a");
				escolha = Integer.parseInt(ler.next());
				if(escolha == 1) {
					Conta cc = new ContaCorrente(correntista, 0);
					System.out.println("Deseja realizar dep�sito? \n1- Sim \n2 - N�o ");
					escolha = Integer.parseInt(ler.next());
					
					if(escolha == 1) {
						System.out.println("Valor do dep�sito: ");
						valor = ler.nextFloat();
						cc.depositar(valor);
						System.out.println("Dep�sito realisado :) ");
						cc.exibirConta();
					}
					contaRepository.adicionar(cc);
				}
				if(escolha == 2) {
					Conta ci = new ContaInvestimento(correntista, 0);
					System.out.println("Deseja realizar dep�sito? \n1- Sim \n2 - N�o ");
					escolha = Integer.parseInt(ler.next());
					if(escolha == 1) {
						System.out.println("Valor do dep�sito: ");
						valor = ler.nextFloat();
						ci.depositar(valor);
						System.out.println("Dep�sito realisado :) ");
						ci.exibirConta();
					}
					contaRepository.adicionar(ci);
				}
				if(escolha == 3) {
					Conta cp = new ContaPoupanca(correntista, 0);
					System.out.println("Deseja realizar dep�sito? \n1- Sim \n2 - N�o ");
					escolha = Integer.parseInt(ler.next());
					if(escolha == 1) {
						System.out.println("Valor do dep�sito: ");
						valor = ler.nextFloat();
						cp.depositar(valor);
						System.out.println("Dep�sito realisado :) ");
						cp.exibirConta();
					}
					contaRepository.adicionar(cp);
				}
				
			}
			
			//consultar
			if(escolhaInicial == 2) {
				System.out.println("Consultar por:");
				System.out.println("1 - CPF");
				System.out.println("2 - NOME");
				escolha = Integer.parseInt(ler.next());
				
				if(escolha == 1) {
					System.out.print("Infome o CPF: ");
					 busca = ler.next();
					
					 correntista = correntistaRepository.buscarPorCpf(busca);
					 contaExibir = contaRepository.buscarContaPorCorrentista(correntista);
					 
					 contaExibir.exibirConta();
				}
				if(escolha == 2) {
					System.out.print("Informe o nome:");
					busca = ler.next();
					correntista = correntistaRepository.buscarPorNome(busca);
					
					contaExibir = contaRepository.buscarContaPorCorrentista(correntista);
					contaExibir.exibirConta();
				}
			}
			
			//Depositar
			if(escolhaInicial ==3) {
				String cpfSaida, cpfEntrada;
				Conta contaSaida, contaEntrada;
				System.out.println("------ Transfer�ncia -----");
				System.out.print("Transferir de (cpf): ");
				cpfSaida = ler.next();
				 if(correntistaRepository.buscarPorCpf(cpfSaida)!= null) {
					 	correntista = correntistaRepository.buscarPorCpf(cpfSaida);
					 	contaSaida = contaRepository.buscarContaPorCorrentista(correntista);
					 	contaSaida.exibirConta();
						
					 	System.out.println("Valor a ser Transferido: ");
					 	valor = ler.nextFloat();
						System.out.print("Transferir para (cpf): "); 
						cpfEntrada = ler.next();
						if(correntistaRepository.buscarPorCpf(cpfEntrada)!= null) {

							
							correntista = correntistaRepository.buscarPorCpf(cpfEntrada);
							
							contaEntrada = contaRepository.buscarContaPorCorrentista(correntista);
							contaEntrada.exibirConta();
							contaSaida.transferirPara(contaEntrada, valor);
						 	
							
							System.out.println("Resultado da Transfer�ncia\n");				
						 	contaSaida.exibirConta();
						 	System.out.println("\n");
						 	contaEntrada.exibirConta();
						}
				 }
			}
			
			
		}
		
			
		
	}
	
	
	/*public static void exibirSaldo(Conta cc, Conta cp, Conta ci) {
		System.out.println("Poupan�a: " + cc.getSaldo());
		System.out.println("Corrente: " + cp.getSaldo());
		System.out.println("Investimento: " + ci.getSaldo() );
	}*/

}
