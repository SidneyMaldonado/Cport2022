package app;
import java.util.List;

public class AnalisadorLexico {

	public void analisar(String[] alfabeto, List<String> programa) {
		int erros = 0;
		for(String linha: programa) {
			String[] letras = linha.split("");
			for (String letra: letras) {
			//	System.out.print("letra: " + letra + " => ");
				if (!verificarSeALetraEstaNoAlfabeto(letra, alfabeto)) {
					System.out.println("A letra " + letra + " não está no alfabeto..");
					erros++;
				} else {
					//System.out.println("ok");
				}
			}
		}
		System.out.println("Fim da analise lexica => erros = " + erros);
	}
	public boolean verificarSeALetraEstaNoAlfabeto( String letra, String[] alfabeto) {
		for(String caracter: alfabeto) {
			if (letra.equals(caracter)) {
				return true;
			}
		}
		return false;
	}
	
	
}
