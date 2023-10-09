package Candidatura;

public class Candidato {
    private String nome;
    private double salarioPretendido;
    private boolean hasRespond;

    public Candidato(String nome, double salarioPretendido) {
        this.nome = nome;
        this.salarioPretendido = salarioPretendido;
        this.hasRespond = false;
    }

    public String getNome() {
        return nome;
    }


    public double getSalarioPretendido() {
        return salarioPretendido;
    }

    public boolean hasRespond() {
        return hasRespond;
    }

    public void setHasRespond(boolean hasRespond) {
        this.hasRespond = hasRespond;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + ", SalarioPretendido: " + this.salarioPretendido;
    }
}
