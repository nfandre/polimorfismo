package Repositorios;

import java.util.ArrayList;
import java.util.Collection;

import UsuarioBanco.Correntista;

public class CorrentistaRepository {
	private static Collection<Correntista> correntistas = new ArrayList<Correntista>();
	
	public CorrentistaRepository() {
		
	}
	public CorrentistaRepository(Collection<Correntista> correntista) {
		this.correntistas.addAll(correntista);
	}
	
	public Correntista buscarPorCpf(String cpf) {		
		Correntista resultado = null;
		
		for(Correntista correntista : CorrentistaRepository.correntistas) {
			if(correntista.getCpf().equals(cpf)) {
				resultado = correntista;
				break;
			}
		}
		
		return resultado;
	}
	
}
