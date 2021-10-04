package br.com.senai.loja.test;

import br.com.senai.loja.DAO.CategoriaDAO;
import br.com.senai.loja.DAO.ProdutoDAO;
import br.com.senai.loja.modelo.Categoria;
import br.com.senai.loja.modelo.Produto;
import br.com.senai.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiome Redmi", "6 GB RAM", 8000.0, celulares);

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        em.getTransaction().begin();
        categoriaDAO.cadastrar(celulares);
        categoriaDAO.atualizar(celulares);
        celular.setNome("123");
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
