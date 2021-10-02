package br.com.senai.loja.test;

import br.com.senai.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiome Redmi");
        celular.setDescricao("6 GB RAM");
        celular.setPreco(8000.0);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        em.persist(celular);
        em.close();
        factory.close();
    }
}
