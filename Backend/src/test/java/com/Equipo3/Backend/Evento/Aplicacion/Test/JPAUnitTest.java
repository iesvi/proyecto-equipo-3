package com.Equipo3.Backend.Evento.Aplicacion.Test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUnitTest {
    static EntityManagerFactory emf;
    protected EntityManager em;

    @BeforeClass
    public static void setupStatic() {
        emf = Persistence.createEntityManagerFactory("backmm");
    }

    @Before
    public void setup() {
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.clear();
        em.close();
    }

    @AfterClass
    public static void tearDownStatic() {
        emf.close();
    }

}