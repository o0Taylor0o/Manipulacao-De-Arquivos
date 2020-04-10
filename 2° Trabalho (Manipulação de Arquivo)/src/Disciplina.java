import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Disciplina {
	private String nome;
	private ArrayList <Aluno> alunos = new ArrayList <Aluno>();
	
	public Disciplina(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList <Aluno> getAlunos() {
		return this.alunos;
	}
	public void setAlunos(ArrayList <Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public static Comparator<Aluno> OrdemNome = new Comparator<Aluno>() {
		public int compare(Aluno a1, Aluno a2) {
			String AlunoNome1 = a1.getNome();
			String AlunoNome2 = a2.getNome();
			
			return AlunoNome1.compareTo(AlunoNome2);
		}
	};
}