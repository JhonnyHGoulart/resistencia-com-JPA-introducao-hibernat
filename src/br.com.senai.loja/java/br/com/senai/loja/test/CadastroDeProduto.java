package br.com.senai.loja.test;

import br.com.senai.loja.DAO.ProdutoDAO;
import br.com.senai.loja.modelo.Produto;
import br.com.senai.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiome Redmi");
        celular.setDescricao("6 GB RAM");
        celular.setPreco(8000.0);

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDAO dao = new ProdutoDAO(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
