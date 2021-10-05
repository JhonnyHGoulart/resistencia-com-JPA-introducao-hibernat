package br.com.senai.loja.DAO;

import br.com.senai.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void remover(Produto produto) {
        produto = em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, 136);
    }

    public List<Produto> buscarTodos() {
        //JPQL language
        String jpql = "SELECT p  FROM Produto as p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
}

