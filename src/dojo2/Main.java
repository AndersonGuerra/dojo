package dojo2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int quantidade;
    static float preco;

    // MODIFICADO: fun��o para exibir erro em vermelho
    static void showErro(String texto) {
        System.out.println("\u001B[31m" + texto + "\u001B[0m");
    }

    // MODIFICADO: obt�m a quantidade do produto que vai ser adicionado
    static void setQuantidade() {
        Scanner in = new Scanner(System.in);
        try {
            quantidade = in.nextInt();
        } catch (InputMismatchException e) {
            showErro("\nErro: utilize apenas n�meros inteiros para quantidade");
            System.out.println("Quantidade do produto:");
            setQuantidade();
        }
    }

    // MODIFICADO: obt�m o pre�o do produto que vai ser adicionado
    static void setPreco() {
        Scanner in = new Scanner(System.in);
        try {
            preco = in.nextFloat();
        } catch (InputMismatchException e) {
            showErro("\nErro: utilize o seguinte formato para pre�o: 0,00");
            System.out.println("Pre�o unit�rio: ");
            setPreco();
        }
    }

    public static void main(String[] args) {

        Loja loja = new Loja();
        String opcao;
        String confirm;
        String usuario = "";
        String senha;
        Scanner in = new Scanner(System.in);
        // MODIFICADO: novo scanner para lidar com a cria��o de produtos
        Scanner scannerProdutos = new Scanner(System.in);
        String nomeProduto;
        // MODIFICADO: variavel renomeada de "acertou" para "autenticado"
        boolean autenticado = false;

        System.out.println("Loja XPTO online \n\n");
        System.out.println("Utilizar usu�rio teste e senha teste no primeiro login! \n\n");


        while (autenticado == false) {

            System.out.println("Informe o nome do usu�rio: \n\n");
            usuario = in.next();
            System.out.println("Informe sua senha: \n\n");
            senha = in.next();

            if ((usuario.equals("teste")) && (senha.equals("teste"))) {
                System.out.println("Usu�rio Logado com Sucesso!");
                autenticado = true;
            } else {
                // MODIFICADO: mensagem de erro no login alterada
                System.out.println("Usu�rio ou senha incorreta!");
            }
        }

        System.out.println("Logado como: " + usuario + "\n\n");
        while (true) {
            System.out.println("Pressione:\n\t1 - Adicionar produtos\n\t2 - Excluir Produtos\n\t3 - Exibir produtos\n\t4 - Procurar produto\n\t5 - Sair\nOpcao: ");

            opcao = in.next();
            switch (opcao) {
                case "1":
                    String nome;
                    System.out.println("Nome do Produto a ser Adicionado: ");
                    // MODIFICADO: usando scannerProdutos
                    nome = scannerProdutos.nextLine();
                    System.out.println("Quantidade do produto:");
                    setQuantidade();
                    System.out.println("Pre�o unit�rio: ");
                    setPreco();
                    Produto p = new Produto(nome, quantidade, preco);
                    loja.AdicionaProduto(p);
                    System.out.println("Produto Adicionado");
                    break;
                case "2":
                    System.out.println("Nome do Produto a ser Removido: ");
                    // MODIFICADO: usando scannerProdutos
                    nomeProduto = scannerProdutos.nextLine();
                    if (loja.Busca(nomeProduto)) {
                        System.out.println("\n (y/n) Realmente deseja remover esse produto? " + nomeProduto);
                        confirm = in.next();
                        if (confirm.equals("y")) {
                            if (loja.RemoveProduto(nomeProduto)) {
                                System.out.println("Produto " + nomeProduto + " Removido");
                            }
                        } else {
                            System.out.println("Opera��o Cancelada\n");
                        }
                    } else {
                        System.out.println("Produto: " + nomeProduto + " n�o encontrado");
                    }
                    break;

                case "3":
                    // MODIFICADO: caso n�o existam produtos, exibe uma mensagem diferente
                    if (loja.Quantidade() > 0) {
                        System.out.println("A loja XPTO tem os Seguintes Produtos:\n");
                        loja.ListaTudo();
                    } else {
                        System.out.println("No momento n�o h� produtos em estoque.");
                    }
                    break;
                case "4":
                    System.out.println("Qual o nome do produto a ser buscado: ");
                    // MODIFICADO: usando scannerProdutos
                    nomeProduto = scannerProdutos.nextLine();
                    if (loja.Busca(nomeProduto)) {
                        System.out.println("Produto " + nomeProduto + " encontrado");
                        loja.MostraProdutos(nomeProduto);
                    } else {
                        // MODIFICADO: mensagem alterada
                        System.out.println("Produto: " + nomeProduto + " n�o encontado");
                    }
                    break;
                case "5":
                    System.out.println("Sistema Encerrado com Sucesso!");
                    System.exit(0);
                    break;

                default:   // incluido para tratar op��es de menu inv�lidas
                    System.out.println("Op��o Inv�lida!");
                    break;
            }
        }
    }
}