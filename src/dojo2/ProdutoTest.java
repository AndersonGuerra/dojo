package dojo2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoTest {

    @Test
    public void TesteAddProduto() {

        // MODIFICADO: nome alterado de "prd" para "produto"
        Produto produto = new Produto("Arroz", 20, 10);

        assertEquals("Arroz", produto.getName());
        assertEquals(10, produto.getPreco(), 0.00001);
        assertEquals(20, produto.getQuant());

    }


}
