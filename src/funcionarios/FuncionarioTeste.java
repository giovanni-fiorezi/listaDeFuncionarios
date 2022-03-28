package funcionarios;

import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

import br.com.magnasistemas.RetornaLista.Funcionario;
import br.com.magnasistemas.RetornaLista.Funcionarios;

/**
 * Exercicio proposto onde deveria ser importado um arquivo Jar Tem 100
 * funcionarios e cinco categorias (trainee, jr, pl, sr e arquiteto) A proposta
 * é criar um programa que separe os funcionarios por categoria Ordene por ordem
 * alfabética Faça a somatoria (salario + beneficios) de todos os funcionarios,
 * no final de cada categoria
 * 
 * @author Giovanni Fiorezi
 * @data 21/03/2022
 *
 */

public class FuncionarioTeste {

	public static void main(String[] args) {

		Funcionarios.retornaFuncionarios().stream().collect(Collectors.groupingBy(Funcionario::getCargo)).entrySet()
				.stream().forEach(funcionario -> {
					System.out.println(funcionario.getKey());

					funcionario.getValue().sort(Comparator.comparing(Funcionario::getNome));
					
					funcionario.getValue().forEach(f2 -> {
						System.out.println(f2.getNome() + ", " + (f2.getSalario() + f2.getBeneficios()));
						
					});
					
					int valorTotal = 0;
					for (int i = 0; i < funcionario.getValue().size(); i++) {
						Funcionario ft = funcionario.getValue().get(i);
						valorTotal += somaSalarioEBeneficiosDeTodosPorCategoria(ft);
						
					}
							
					System.out.println("Total: R$ " + valorTotal);
					System.out.println("-----------------------------------------");

				});
	}

	public static double somaSalarioEBeneficiosDeTodosPorCategoria(Funcionario f) {
		return f.getSalario() + f.getBeneficios();
	}

}
