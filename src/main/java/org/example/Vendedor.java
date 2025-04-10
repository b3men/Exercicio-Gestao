package org.example;

import javax.swing.*;

public class Vendedor extends Funcionario{

    protected double qtdVendas, valorPorVenda;
    public Vendedor(String nome, double salarioBase, double qtdVendas, double valorPorVenda) {
        super(nome, salarioBase);
        this.qtdVendas = qtdVendas;
        this.valorPorVenda = valorPorVenda;
        verificaValorNegativo();
    }

    @Override
    public void verificaValorNegativo() {
        super.verificaValorNegativo();

        if (qtdVendas < 0 || valorPorVenda < 0) {
            JOptionPane.showMessageDialog(null, "A quantidade de vendas e/ou o valor por venda não podem ser negativos e serão definidos como 0.");
            qtdVendas = 0;
            valorPorVenda = 0;
        }
    }

    @Override
    public double calculaSalario() {
        return salarioBase + (qtdVendas * valorPorVenda);
    }

    @Override
    public String toString() {
        String ret = "";
        return ret;
    }
}
