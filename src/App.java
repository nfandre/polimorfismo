 import java.util.Scanner;

import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaInvestimento;
import Banco.ContaPoupanca;
import Banco.TipoConta;
import Repositorios.ContaRepository;
import Repositorios.CorrentistaRepository;
import UsuarioBanco.Correntista;

public class App {

	public static void main(String[] args) throws Exception {
		
		
		ContaCadastro contaCadastro;
		CorrentistaRepository correntistaRepository = new CorrentistaRepository();
		CorrentistaCadastro correntistaCadastro = new CorrentistaCadastro();
		TipoConta tipoConta = null;
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
				
				correntista = correntistaCadastro.correntistaCadastrar();
				System.out.println("Tipo de conta a ser criada: ");
				System.out.println("1 - Conta Corrente \n2 - Conta Corrente \n3 - Conta Poupança");
				escolha = Integer.parseInt(ler.next());
				switch(escolha) {
					case 1: 
						tipoConta = TipoConta.Corrente;
					case 2: 
						tipoConta = TipoConta.Poupanca;
					case 3: 
						tipoConta = TipoConta.Investimento;
				}			
				contaCadastro = new ContaCadastro(correntista, tipoConta);
				
				System.out.println("Deseja realizar depósito? \n1- Sim \n2 - Não ");
				escolha = Integer.parseInt(ler.next());
					
				if(escolha == 1) {
					System.out.println("Valor do depósito: ");
					valor = ler.nextFloat();
					contaCadastro.realizarDeposito(valor);
				}
				contaCadastro.exibirConta();
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
				System.out.println("------ Transferência -----");
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
						 	
							
							System.out.println("Resultado da Transferência\n");				
						 	contaSaida.exibirConta();
						 	System.out.println("\n");
						 	contaEntrada.exibirConta();
						}
				 }
			}
			
			
		}
		
			
		
	}

}
