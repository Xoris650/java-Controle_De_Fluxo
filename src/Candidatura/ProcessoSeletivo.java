package Candidatura;

import java.io.IOException;
import java.util.*;

public class ProcessoSeletivo {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Random().nextBoolean());
        List<Candidato> candidatos = cadastroCandidatos(menu());
        List<Candidato> candidatosAprovados = analisarCandidatos(candidatos);
        System.out.println("------------------\nOs candidatos aprovados foram:");
        for (Candidato candidato : candidatosAprovados) {
            System.out.println(candidato.getNome());
        }

        System.out.println("------------------\nEntrando em contato...");
        for (Candidato candidato : candidatosAprovados){
            contatar(candidato);
        }

    }

    public static int menu() {
        System.out.println("------------------\nProcesso Seletivo\n------------------");
        System.out.println("Quantos candidatos foram inscritos");
        return sc.nextInt();

    }

    public static List<Candidato> cadastroCandidatos(int numCandidatos) {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        for (int i = 0; i < numCandidatos; i++) {
            System.out.print("Nome do candidato: ");
            //sc.next();
            String nomeCandidato = sc.next();
            System.out.print("Salario Pretendido: ");
            double salarioPretendido = sc.nextDouble();
            candidatos.add(new Candidato(nomeCandidato, salarioPretendido));
        }
        return candidatos;
    }

    public static List<Candidato> analisarCandidatos(List<Candidato> candidatos) {
        double salarioBase = 2000.0;
        List<Candidato> aprovados = new ArrayList<Candidato>();
        //System.out.println(candidatos.size());
        for (Candidato candidato : candidatos) {
            double salarioPretendido = candidato.getSalarioPretendido();
            System.out.print("------------------\nCandidato '" + candidato.getNome() + "': ");
            if (salarioBase > salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO");
                if (aprovados.size() <5){
                    aprovados.add(candidato);
                }
            } else if (salarioBase == salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
                if (aprovados.size() <5){
                    aprovados.add(candidato);
                }
            } else {
                System.out.println("AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS");
            }
        }


        return aprovados;
    }
    static void contatar(Candidato candidato){
        int tentativas = 1;
        boolean continuarTentando = true;
        do{
            foiContatado(candidato);
            if(candidato.hasRespond()){
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato.getNome());
                continuarTentando = false;
            }else{
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato.getNome());
                tentativas++;
            }
        }while(continuarTentando && tentativas < 3);


    }
    static void foiContatado(Candidato candidato){
        candidato.setHasRespond(new Random().nextBoolean());
    }


}
