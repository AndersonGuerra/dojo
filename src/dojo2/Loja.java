package dojo2;

import java.util.ArrayList;
import java.util.List;


public class Loja {
    protected List<Produto> produtos;

    public Loja() {
        this.produtos = new ArrayList<>();
    }

    // MODIFICADO: alterado "addProduto" para "AdicionaProduto"
    public void AdicionaProduto(Produto produto) {
        // MODIFICADO: produto é adicionado se a quantidade for maior ou igual a 0
        // se a quantidade for negativa então a exceção é lançada
        if (produto.getQuant() >= 0) {
            this.produtos.add(produto);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean RemoveProduto(String nomeProduto) {
        for (Produto p : this.produtos) {
            if (p.getName().equals(nomeProduto)) {
                this.produtos.remove(p);
                return true;
            }
        }
        return false;
    }

    public void MostraProdutos(String nome) {
        if (this.Quantidade() > 0) {
            for (Produto p : this.produtos) {
                // MODIFICADO: alterado de equals para equalsIgnoreCase
                if (p.getName().equalsIgnoreCase(nome)) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Carrinho de Compras Vazio.\n");
        }
    }

    public int Quantidade() {
        return this.produtos.size();
    }

    public boolean Busca(String nomeProduto) {
        for (Produto p : this.produtos) {
            // MODIFICADO: alterado de equals para equalsIgnoreCase
            if (p.getName().equalsIgnoreCase(nomeProduto)) {
                return true;
            }
        }
        return false;
    }

    public void ListaTudo() {
        for (Produto p : this.produtos) {
            System.out.println(p);
            // MODIFICADO: Adicionada uma linha de separação na
            // exibição dos produtos
            System.out.println("***************");
        }
        System.out.println();
    }


}
