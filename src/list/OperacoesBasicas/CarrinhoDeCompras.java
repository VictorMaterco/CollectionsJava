package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if(!itemList.isEmpty()) {
            for (Item i : itemList) {
                if(i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for(Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuant();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista vazia!");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itemList=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        // Adicionando itens ao carrinho
        carrinho.adicionarItem("Lápis", 2d, 3);
        carrinho.adicionarItem("Lápis", 2d, 3);
        carrinho.adicionarItem("Caderno", 35d, 1);
        carrinho.adicionarItem("Borracha", 2d, 2);

        //Exibindo os itens no carrinho
        carrinho.exibirItens();

        //removendo um item no carrinho
        carrinho.removerItem("Lápis");

        //Exibindo os iens atualizados no carrinho
        carrinho.exibirItens();

        // calculando e exibindo o valor total de compra
        System.out.println("O valor total de compra é = R$" + carrinho.calcularValorTotal());


    }
}


