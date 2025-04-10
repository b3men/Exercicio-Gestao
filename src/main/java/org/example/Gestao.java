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
    public static void imprimeFuncionario(List<Funcionario> funcionarios) {
        funcionarios = getFuncionario();
        for (Funcionario funcionario : funcionarios) {
            JOptionPane.showMessageDialog(null, funcionario.getNome());
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
    public static void imprimeVendedor(List<Vendedor> vendedores) {
        vendedores = getVendedor();
        for (Vendedor vendedor : vendedores) {
            JOptionPane.showMessageDialog(null, vendedor.getNome());
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
