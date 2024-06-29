import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Models.Aluno;

public class App {
    public static void main(String[] args) throws Exception {
        String csvFile = "alunos.csv";
        String line;
        String cvsSplitBy = ";";
        List<Aluno> alunos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int matricula = Integer.parseInt(data[0].trim());
                String nome = data[1].trim();
                double nota = Double.parseDouble(data[2].replace(',', '.').trim());

                Aluno aluno = new Aluno(matricula, nome, nota);
                alunos.add(aluno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int totalAlunos = alunos.size();
        int aprovados = 0;
        int reprovados = 0;
        double maiorNota = Double.MIN_VALUE;
        double menorNota = Double.MAX_VALUE;

        for (Aluno aluno : alunos) {
            if (aluno.foiAprovado()) {
                aprovados++;
            } else {
                reprovados++;
            }

            if (aluno.getNota() > maiorNota) {
                maiorNota = aluno.getNota();
            }

            if (aluno.getNota() < menorNota) {
                menorNota = aluno.getNota();
            }
        }

        // resultados
        System.out.println("Total de alunos na turma: " + totalAlunos);
        System.out.println("Alunos aprovados: " + aprovados);
        System.out.println("Alunos reprovados: " + reprovados);
        System.out.println("Maior nota da turma: " + maiorNota);
        System.out.println("Menor nota da turma: " + menorNota);

        // resultados em resumo.csv
        String outputFile = "resumo.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Total de alunos na turma:," + totalAlunos + "\n");
            bw.write("Alunos aprovados:," + aprovados + "\n");
            bw.write("Alunos reprovados:," + reprovados + "\n");
            bw.write("Maior nota da turma:," + maiorNota + "\n");
            bw.write("Menor nota da turma:," + menorNota + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
