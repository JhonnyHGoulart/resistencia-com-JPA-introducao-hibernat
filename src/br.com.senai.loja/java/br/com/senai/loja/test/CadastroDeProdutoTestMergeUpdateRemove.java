package br.com.senai.loja.test;

import br.com.senai.loja.DAO.CategoriaDAO;
import br.com.senai.loja.DAO.ProdutoDAO;
import br.com.senai.loja.modelo.Categoria;
import br.com.senai.loja.modelo.Produto;
import br.com.senai.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDeProdutoTestMergeUpdateRemove {
    public static void main(String[] args) {

        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi", "8G RAM", 1600.0, celulares);

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        categoriaDAO.cadastrar(celulares);
        produtoDAO.cadastrar(celular);
        em.flush();
        em.clear();

//        produtoDAO.atualizar(celular);
        celular = em.merge(celular);
        celular.setNome("Iphone 11");
        celular.setDescricao("Sem carregador");
        em.flush();
        produtoDAO.remover(celular);
//        em.remove(celular);
        em.getTransaction().commit();
        em.close();
    }
}
