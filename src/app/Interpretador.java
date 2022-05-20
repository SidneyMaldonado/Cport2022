package app;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Interpretador {
	
	public List<String> programa; 
	HashMap<String, Integer> tabela;

	
	public void executar(List<String> programa) {
		this.programa = programa;
		tabela = new HashMap<String,Integer>();
		
		System.out.println("Interpretando o programa...");
		int numeroLinha = 0;
		processarLinha(programa.get(0), numeroLinha);
		System.out.println("Fim do interpretador...");
	}
	public void processarLinha(String linha, int nr) {
		System.out.println("  processando linha:"+nr +": " + linha);
		
		if (nr == 0) { // estou no titulo do programa
			// o bloco comeca na linha 1
			fazer( programa, 1);
		}
		
	}
	public int fazer(List<String> programa, int numeroLinha) {
		//System.out.println("---" + numeroLinha);
		for(int i=numeroLinha; i < programa.size();i++) {
			String linha = programa.get(i);
			processarInstrucao(linha);
			if (linha.contains("{")) {
				i = fazer(programa, i+1);
			}
			if (linha.contains("}")) {
				return i;
			}
		}
		return numeroLinha;
	}
	
	public void processarInstrucao( String comando) {
		String[] token = comando.split(" ");
		// processamento do int
		if (token[0].equals("int")) {
			this.tabela.put(token[1],0);
		}
		// linha =  "Digite um numero:"
		if (token[0].equals("escreva")) {
			// se estiver na tabela de simbolos
			if (tabela.containsKey(token[1])) {
				System.out.println(tabela.get(token[1]));
			} else {
				String texto = comando.replace("escreva ", "").replace("\"","");
				System.out.println(texto);
			}
		}
		
		if (token[0].equals("leia")) {
			Scanner teclado = new Scanner(System.in);
			int temp;
			temp = teclado.nextInt();
			tabela.put(token[1],temp);
		}
		
		// processar atribuicao
		if (tabela.containsKey(token[0]))
		if (token[1].equals("=")) {
			processarAtribuicao(token);
		}
	}
	
	public void processarAtribuicao(String[] token) {
		int t1;
		int t2;
		int r = 0;
		String operador;
		t1 = tabela.get(token[2]);
		t2 = tabela.get(token[4]);
		operador = token[3];
		if (operador.equals("*")) {
			r = t1 * t2;
		}
		if (operador.equals("/")) {
			r = t1 / t2;
		}
		if (operador.equals("-")) {
			r = t1 - t2;
		}
		if (operador.equals("+")) {
			r = t1 + t2;
		}
		tabela.put(token[0],r);
	}
}
