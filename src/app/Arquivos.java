package app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	
	public String[] alfabeto;
	public List<String> dicionario;
	public List<String> expressoes;
	public List<String> programa;
	public Arquivos() throws IOException {
		List<String> alfabetoLinhas;
		String dirbase = "src\\arquivos";
		alfabetoLinhas = lerArquivo(dirbase + "\\alfabeto.txt");
		dicionario= lerArquivo(dirbase +"\\dicionario.txt");
		expressoes = lerArquivo(dirbase + "\\expressoes.txt");
		programa= lerArquivo(dirbase + "\\exemplo.txt");
		
		String temp="";
		for(String linha: alfabetoLinhas) {
			temp += linha;
		}
		alfabeto = temp.split("");
	}
	
	@SuppressWarnings("resource")
	public List<String> lerArquivo(String arquivo) throws IOException{
		

		System.out.println("Arquivo lido:" + arquivo);
		
		List<String> conteudo = new ArrayList<>();
		FileReader leitor= new FileReader(arquivo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha;
		while ((linha = buffer.readLine()) != null) {
				conteudo.add(linha);
		}
		return conteudo;
	}
	
	public void imprimirArquivo(List<String> arquivo) {
		for(String linha: arquivo) {
			System.out.println(linha);
		}
	}

}
