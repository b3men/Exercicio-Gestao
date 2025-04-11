package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Gestao {

    //cadastro de funcionario
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<Funcionario> getFuncionario() { return funcionarios;}
    public static void cadastraFuncionario(String nome, double salarioBase) {
        Funcionario f = new Funcionario(nome, salarioBase);
        funcionarios.add(f);
    }
    //imprime lista de funcionarios cadastrados
    public static void imprimeFuncionario(ArrayList<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado.");
        } else {
            StringBuilder mensagem = new StringBuilder("Lista de Funcionários:\n");
            for (Funcionario f : funcionarios) {
                mensagem.append(f.getNome())
                        .append(" - Salário: R$")
                        .append(f.calculaSalario())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString());
        }
    }


    // cadastro de vendedores
    static ArrayList<Vendedor> vendedores = new ArrayList<>();
    public static ArrayList<Vendedor> getVendedor() {return vendedores; }
    public static void cadastraVendedor(String nome, double salarioBase, double qtdVendas, double valorPorVenda) {
        Vendedor v = new Vendedor(nome, salarioBase, qtdVendas, valorPorVenda);
        vendedores.add(v);
    }
    //imprime lista de vendedores cadastrados
    public static void imprimeVendedor(ArrayList<Vendedor> vendedores) {
        if (vendedores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado.");
        } else {
            StringBuilder mensagem = new StringBuilder("Lista de Vendedores:\n");
            for (Vendedor v : vendedores) {
                mensagem.append(v.getNome())
                        .append(" - Salário: R$")
                        .append(v.calculaSalario())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString());
        }
    }


    public static void main(String[] args) {
        int op = 0;
        String menu = " Menu \n" +
                "1- Cadastrar um Funcionario. \n" +
                "2- Cadastrar um Vendedor. \n" +
                "3- Imprime Funcionarios. \n" +
                "4- Imprime Vendedores \n" +
                "5- Sair. \n";

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
            if (op == 1) {
                String nome = JOptionPane.showInputDialog(null, "Digite o nome:");
                double salarioBase = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario base:"));
                cadastraFuncionario(nome, salarioBase);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            }
            if (op == 2) {
                String nomeVendedor = JOptionPane.showInputDialog(null, "Digite o nome:");
                double salarioBaseVendedor = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario base:"));
                double qtdVendas = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de vendas no mês:"));
                double valorPorVenda = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de comissão por venda:"));
                cadastraVendedor(nomeVendedor, salarioBaseVendedor, qtdVendas, valorPorVenda);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            }
            if (op == 3) imprimeFuncionario(getFuncionario());
            if (op == 4) imprimeVendedor(getVendedor());

        } while (op != 5);

    }
}
