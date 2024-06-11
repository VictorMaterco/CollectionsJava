package list.OrdenacaoDePessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoas {
    //atributo
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas op = new OrdenacaoPessoas();
        op.adicionarPessoa("Nome 1", 20, 1.56);
        op.adicionarPessoa("Nome 2", 30, 1.80);
        op.adicionarPessoa("Nome 3", 25, 1.78);
        op.adicionarPessoa("Nome 4", 17, 1.56);

        System.out.println(op.ordenarPorIdade());
        System.out.println(op.ordenarPorAltura());
    }
}
