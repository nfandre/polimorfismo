import java.util.Scanner;

import Repositorios.CorrentistaRepository;
import UsuarioBanco.Correntista;

public class CorrentistaCadastro   {
	Scanner ler = new Scanner(System.in);
	public CorrentistaCadastro() {


	}
	public Correntista correntistaCadastrar() {
		Correntista correntista = new Correntista();
		CorrentistaRepository correntistaRepository = new CorrentistaRepository();
		System.out.println("Cadastro do correntista: ");
		correntista = new Correntista();
		correntistaRepository.adicionar(correntista);
		System.out.print("Nome: ");
		correntista.setNome(ler.next());
		System.out.print("CPF: ");
		correntista.setCpf(ler.next());
		return correntista;
	}
}
