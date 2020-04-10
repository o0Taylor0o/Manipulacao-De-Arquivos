import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	private static final Arrays Array = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner nome = new Scanner(System.in);
	
		Disciplina d = null;
		Aluno aluno;
		
		int aux;
		String nomeDisciplina = "";
		String nomeAluno = "";
		char resposta[] = null;
		char gabOfs[] = null;

		try {
			File pasta = new File("Disciplinas");
			pasta.mkdir();
			File pasta1 = new File("Gabaritos");
			pasta1.mkdir();
			
			FileOutputStream arquivo = null;
			PrintWriter pr = null;
			BufferedWriter bw = null;
			
			BufferedReader br;
			do {
				System.out.println();
				System.out.println("Digite 1 para criar uma disciplina.");
				System.out.println("Digite 2 para adicionar aluno na atual disciplina.");
				System.out.println("Digite 3 para criar o arquivo da atual disciplina.");
				System.out.println("Digite 4 para botar o gabarito ofical.");
				aux = scan.nextInt();
				switch(aux) {
					case 1:
						System.out.println("Digite o nome da disciplina: ");
						nomeDisciplina = nome.nextLine();
						d = new Disciplina(nomeDisciplina);
						arquivo = new FileOutputStream("Disciplinas/" + nomeDisciplina + ".txt");
						pr = new PrintWriter(arquivo);
						bw = new BufferedWriter(pr);
							break;
					case 2:
						System.out.println("Digite o nome do aluno:");
						nomeAluno = nome.nextLine().toUpperCase();
						System.out.println("Digite as respostas do aluno: " + nomeAluno + " (Ex.: FFFVVFVVVV)");
						resposta = scan.next().toUpperCase().toCharArray();
						aluno = new Aluno(nomeAluno, resposta);
						d.addAluno(aluno);
							break;
					case 3:
						pr.println("LISTA POR ORDEM DE CADRASTO");
						for(int i = 0; i < d.getAlunos().size(); i++) {
							String l = d.getAlunos().get(i).getResposta() + "\t" + d.getAlunos().get(i).getNome();
							pr.println(l);
						}
						System.out.println("Arquivo criado !");
						pr.close();
						bw.close();
						arquivo.close();
							break;
				}
			}while(aux != 4);	
			
				System.out.println("Digite o gabarito oficial. (Ex.: VVVFFVFVFF)");
				arquivo = new FileOutputStream("Gabaritos/" + "Gabarito.txt");
				pr = new PrintWriter(arquivo);
				bw = new BufferedWriter(pr);
				gabOfs = scan.next().toUpperCase().toCharArray();
				String gab = new String(gabOfs);
				pr.println("GABARITO OFICIAL !!");
				pr.println(gab);
				System.out.println("Arquivo criado !");
						
				pr.close();
				bw.close();
				arquivo.close();
				
				System.out.println();
				System.out.println("Disciplinas cadastradas:");
				String arqs[] = pasta.list();
				
				for(int j = 0; j < arqs.length; j++) {
					System.out.println(arqs[j]);
				}
				
				System.out.println();
				System.out.println("Resultado da disciplina: " + nomeDisciplina);
				System.out.println();
				
				
				arquivo = new FileOutputStream("Disciplinas/" + "Resultado ordem alfabetica.txt");
				pr = new PrintWriter(arquivo);
				bw = new BufferedWriter(pr);
				
				double nota = 0;
				for(int i = 0; i < d.getAlunos().size(); i++) {
					int soma = 0;
					soma = d.getAlunos().get(i).getNota(gab);
					nota += soma;
				}
				
				pr.println("LISTA POR ORDEM ALFABETICA !!");
				Collections.sort(d.getAlunos(), Disciplina.OrdemNome);
				for(int i = 0; i < d.getAlunos().size(); i++) {
					String x = d.getAlunos().get(i).getResposta() + "\t" + d.getAlunos().get(i).getNome();
					int y = d.getAlunos().get(i).getNota(gab);
					
					pr.print(x);
					pr.println("\t Numero de acertos: " + y);
				}
				
				double media = (nota/d.getAlunos().size());
				String resultMedia = String.format("%.2f", media);
				pr.println("\n\t\t Media da turma: " + resultMedia + ".");
				
				pr.close();
				bw.close();
				arquivo.close();
				
			
				arquivo = new FileOutputStream("Disciplinas/" + "Resultado ordem de nota.txt");
				pr = new PrintWriter(arquivo);
				bw = new BufferedWriter(pr);
				
				int y = 0;
				ArrayList<Integer> notas = new ArrayList<Integer>();
				pr.println("LISTA POR ORDEM DE NOTA !!");
				Collections.sort(notas, Collections.reverseOrder());
				for(int i = 0; i < d.getAlunos().size(); i++) {
					String x = d.getAlunos().get(i).getResposta() + "\t" + d.getAlunos().get(i).getNome();
					y = d.getAlunos().get(i).getNota(gab);
					notas.add(y);
					pr.print(x);
					pr.println("\t Numero de acertos: " + y);
				}
				String resultMedia1 = String.format("%.2f", media);
				pr.println("\n\t\t Media da turma: " + resultMedia1 + ".");
				
				pr.close();
				bw.close();
				arquivo.close();
		
				br = new BufferedReader(new FileReader("Disciplinas/"+ nomeDisciplina + ".txt"));
				
				while(br.ready()) {
					String linha = br.readLine();
					System.out.println(linha);
				}
				br.close();
				
				System.out.println("--------------------------------------------------------");
				
			
				br = new BufferedReader(new FileReader("Gabaritos/Gabarito.txt"));
				
				while(br.ready()) {
					String linha = br.readLine();
					System.out.println(linha);
				}
				br.close();
				
				System.out.println("--------------------------------------------------------");
				
				
				br = new BufferedReader(new FileReader("Disciplinas/Resultado ordem alfabetica.txt"));
				
				while(br.ready()) {
					String linha = br.readLine();
					System.out.println(linha);
				}
				br.close();
				
				System.out.println("--------------------------------------------------------");
				
				
//				br = new BufferedReader(new FileReader("Disciplinas/Resultado ordem de nota.txt"));
//				
//				while(br.ready()) {
//					String linha = br.readLine();
//					System.out.println(linha);
//				}
//				br.close();
					
		}catch(IOException e) {
			System.out.println("Erro ao criar arquivo.");
		}catch(Exception e) {
			System.out.println("Erro ao abrir o arquivo.");
		}

	}
}