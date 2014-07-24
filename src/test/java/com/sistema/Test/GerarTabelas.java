package com.sistema.Test;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sistema.Entity.ModeloCarro;

public class GerarTabelas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static EntityManagerFactory factory;
	private EntityManager em;
	
	@BeforeClass
	public static void criarFactory(){
		factory = Persistence.createEntityManagerFactory("JavaParaWebPU");
	}
	
	@Before
	public void criarManager(){
		this.em = factory.createEntityManager();
	}
	
	@After
	public void fecharManager(){
		this.em.close();
	}
	
	@Test
	public void gerarTabelas(){
		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setDescricao("Palio");
		modeloCarro.setFabricacao("Fiat");
		modeloCarro.setAnoFabricacao("2012");
		
		this.em.getTransaction().begin();
		this.em.persist(modeloCarro);
		this.em.getTransaction().commit();
	}

}
