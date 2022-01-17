package dojo2;

import java.text.DecimalFormat;

public class Produto {
	
	protected String nome;
	
	protected int quant;
	
	protected double preco;

	public Produto(String nome, int quantidade, double preco) {
		//pre�o alterado de float para double
		
		super();
		this.nome = nome;
		this.quant = quantidade;
		this.preco = preco;
		 
	}

	public String getName() {
		return nome;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getQuant() {
		return quant;
	}

	public void setQuant(int quantidade) {
		this.quant = quantidade;
		
	}
	

	@Override
	public String toString() {
		// MODIFICADO: Altera��o na exibi��o do produto
		// pre�o exibido com at� 2 casas decimais
		return "Nome do Produto = " + nome + "\nQuantidade = " + quant + "\nPre�o = R$" + new DecimalFormat("0.##").format(preco) ;
	}
	
	
}
