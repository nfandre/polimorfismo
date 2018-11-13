import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaInvestimento;
import Banco.ContaPoupanca;
import Banco.TipoConta;
import Repositorios.ContaRepository;
import UsuarioBanco.Correntista;

public class ContaCadastro {
	
	ContaRepository  contaRepository = new ContaRepository();
	Conta c = null;
	public ContaCadastro(Correntista correntista, TipoConta tipoConta) {

		if(tipoConta.Corrente == TipoConta.Corrente) {
			 c = new    ContaCorrente(correntista, 0);
		}
		if(tipoConta.Poupanca == TipoConta.Poupanca) {
			 c = new    ContaPoupanca(correntista, 0);
		}
		if(tipoConta.Investimento == TipoConta.Investimento) {
			 c = new    ContaInvestimento(correntista, 0);
		}
		contaRepository.adicionar(c);
		
	}
	
	public void realizarDeposito(float valor) {
		c.depositar(valor);
		
		System.out.println("Depósito realisado :) ");
	}
	public void exibirConta() {
		System.out.println("Correntista: "+ c.getCorrentista().getNome());
		System.out.println("CPF: "+ c.getCorrentista().getCpf());
		System.out.println("Número da Conta: "+ c.getNumeroConta());
		System.out.println("Saldo: "+ c.getSaldo());
	}
}
