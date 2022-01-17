package dojo2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class LojaTest {

    // MODIFICADO: novo teste criado (para verificar inserção de produto na loja)
    @Test
    public void TesteAdicionarProduto() {
        Loja loja = new Loja();
        Produto produto = new Produto("Arroz", 20, 10);

        loja.AdicionaProduto(produto);
        assertEquals(1, loja.Quantidade());
        assertEquals(true, loja.Busca("Arroz"));
        assertEquals(true, loja.Busca("arroz"));
    }

    @Test
    public void TesteRemoverProduto() {
        Loja loja = new Loja();
        // MODIFICADO: nome "prd" para "produto"
        Produto produto = new Produto("Arroz", 20, 10);

        loja.AdicionaProduto(produto);
        loja.RemoveProduto("Arroz");

        assertEquals(false, loja.Busca("Arroz"));
    }

    @Test
    public void TesteListarProdutos() {
        Loja loja = new Loja();
        Produto prd1 = new Produto("Arroz", 20, 10);
        Produto prd2 = new Produto("Feijão", 5, 15);
        Produto prd3 = new Produto("Macarrão", 4, 10);

        loja.AdicionaProduto(prd1);
        loja.AdicionaProduto(prd2);
        loja.AdicionaProduto(prd3);

        assertEquals(3, loja.Quantidade());
    }


    @Test
    public void TesteBuscarProduto() {

        Loja loja = new Loja();
        Produto prd = new Produto("Arroz", 20, 10);

        loja.AdicionaProduto(prd);

        assertEquals(true, loja.Busca("Arroz"));
        // MODIFICADO: teste com busca em lower e uppercase alternados
        assertEquals(true, loja.Busca("aRROZ"));

    }

    @Test //(expected = IllegalArgumentException.class)
    public void TesteExecucaoProduto() {
        // MODIFICADO: nome "prd" para "produto"
        // MODIFICADO: quantidade de produto foi inserida como -1
        Loja loja = new Loja();
        Produto produto = new Produto("Arroz", -1, 10);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            loja.AdicionaProduto(produto);
        });
    }
}
