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
        Produto p = produtoDAO.buscarPorId(136L);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDAO.buscarTodos();
            todos.stream().forEach(System.out::println);
    }
}
