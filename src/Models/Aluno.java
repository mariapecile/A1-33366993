package Models;

//declarando classe aluno 
public class Aluno {
    private int matricula;
    private String nome;
    private double nota;

    // construtor para saber quais informações dos alunos
    public Aluno(int matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    // getters (para ter acesso as informações dos alunos)
    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    // verificar se o aluno foi aprovado
    public boolean foiAprovado() {
        return nota >= 6.0;
    }
}
