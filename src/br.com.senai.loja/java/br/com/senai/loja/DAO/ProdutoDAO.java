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

    public List<Produto> buscarComFiltro(String nome) {
        String jpql = "SELECT p FROM Produto as p WHERE p.nome = :nome";
//        String jpql = "SELECT p FROM Produto as p WHERE p.nome = :nome"; parametro posicional
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDeCategoria(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public Double buscarPrecodoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Double.class)
                .setParameter("nome", nome).setMaxResults(1)
                .getSingleResult();

    }
}

