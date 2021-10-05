package br.com.senai.loja.test;

import br.com.senai.loja.DAO.ProdutoDAO;
import br.com.senai.loja.modelo.Produto;
import br.com.senai.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ConsultaDeEntidadeComJPQL {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
//        Produto produto = produtoDAO.buscarPorId(136L);
//        System.out.println(produto.getPreco());
//
//        List<Produto> produtos = produtoDAO.buscarTodos();
//        produtos.stream().forEach(System.out::println);
//
//        List<Produto> produtos1 = produtoDAO.buscarComFiltro("Xiaomi");
//        produtos1.stream().forEach(p1 -> System.out.println(p1.getNome()));

        List<Produto> produtos2 = produtoDAO.buscarPorNomeDeCategoria("CELULARES");
        produtos2.stream().forEach(p2 -> System.out.println(p2.getNome()));

    }
}
