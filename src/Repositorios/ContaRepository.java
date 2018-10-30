package Repositorios;

import java.util.ArrayList;
import java.util.Collection;

import Banco.Conta;
import UsuarioBanco.Correntista;

public class ContaRepository {
	
	private static Collection<Conta> contas = new ArrayList<Conta>();
	
	public ContaRepository() {
		
	}
	public ContaRepository(Collection<Conta> conta) {
		this.contas.addAll(conta);
	}
	public Conta buscarContaPorCorrentista(Correntista correntista) {
		Conta resultado = null;	
		for(Conta conta: ContaRepository.contas) {

			if(conta.getCorrentista().equals(correntista)) {
				resultado = conta;
				break;
			}
		}
		return resultado;
	}
	
	public void adicionar(Conta conta) {
		ContaRepository.contas.add(conta);
	}
}
