package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GestaoTest {

    @Test
    public void testFuncionarioComSalarioNegativo() {
        Funcionario f = new Funcionario("João", -1000);
        f.verificaValorNegativo(); // precisa ser chamada manualmente
        assertEquals(0.0, f.calculaSalario(), 0.01);
    }

    @Test
    public void testVendedorComSalarioNegativo() {
        Vendedor v = new Vendedor("Maria", -1500, 5, 100);
        assertEquals(0.0, v.getSalarioBase(), 0.01);
    }

    @Test
    public void testVendedorComComissaoNegativa() {
        Vendedor v = new Vendedor("Carlos", 2000, 10, -50);
        v.verificaValorNegativo();
        assertEquals(2000.0, v.calculaSalario(), 0.01); // comissão deve ser zerada
    }

    @Test
    public void testVendedorComQtdVendasNegativa() {
        Vendedor v = new Vendedor("Ana", 2000, -5, 100);
        v.verificaValorNegativo();
        assertEquals(2000.0, v.calculaSalario(), 0.01); // vendas devem ser zeradas
    }

    @Test
    public void testFuncionarioComSalarioValido() {
        Funcionario f = new Funcionario("Bruno", 2500);
        f.verificaValorNegativo();
        assertEquals(2500.0, f.calculaSalario(), 0.01);
    }

    @Test
    public void testVendedorComSalarioEComissaoValidos() {
        Vendedor v = new Vendedor("Fernanda", 1200, 10, 50);
        assertEquals(1700.0, v.calculaSalario(), 0.01); // 1200 + 500
    }

    @Test
    public void testFuncionarioEVendedorMesmoSalarioSemVendas() {
        Funcionario f = new Funcionario("Funcionario", 1500);
        f.verificaValorNegativo();

        Vendedor v = new Vendedor("Vendedor", 1500, 0, 100);
        v.verificaValorNegativo();

        assertEquals(f.calculaSalario(), v.calculaSalario(), 0.01); // Ambos 1500
    }

    @Test
    public void testFuncionarioEVendedorMesmoSalarioComVendas() {
        Funcionario f = new Funcionario("Funcionario", 1500);
        Vendedor v = new Vendedor("Vendedor", 1500, 10, 50);

        // O vendedor deve ganhar mais que o funcionário (2000 > 1500)
        assertTrue(v.calculaSalario() > f.calculaSalario());

        assertEquals(2000.0, v.calculaSalario(), 0.01);
        assertEquals(1500.0, f.calculaSalario(), 0.01);
    }
}
