package org.example;

public class Funcionario {

    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        verificaValorNegativo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public void verificaValorNegativo() {
        if (salarioBase < 0) {
            salarioBase = 0;
        }
    }

    public double calculaSalario() {
        return salarioBase;
    }

    @Override
    public String toString() {
        String ret = "";
        return ret;
    }
}
