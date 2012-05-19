/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.mysqldemo1;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author intesar
 */
public class MySQLDemo {

    /**
     * @param args the command line arguments
     *
     * inserts : 50, time : 1662 inserts : 100, time : 1643 inserts : 200, time
     * : 1926 inserts : 500, time : 2778 inserts : 1000, time : 4611
     *
     * gets : 50, time : 1329 gets : 100, time : 1349 gets : 200, time : 1592
     * gets : 500, time : 1702 gets : 1000, time : 2197
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //runGet (example, bucket, 10000);

        runSet(50);
        runSet(100);
        runSet(200);
        runSet(500);
        runSet(1000);
        
        runGet(50);
        runGet(100);
        runGet(200);
        runGet(500);
        runGet(1000);
    }

    public static void runSet(int max) {
        long st = new Date().getTime();
        int i = 0;
        for (; i < max; i++) {
            persist(new NewTable("apple", "apple"));
        }
        long et = new Date().getTime();
        System.out.println(" inserts : " + i + ", time : " + (et - st));
    }

    public static void runGet(int max) {
        long st = new Date().getTime();
        int i = 0;
        for (; i < max; i++) {
            load(i);
        }
        long et = new Date().getTime();
        System.out.println(" gets : " + i + ", time : " + (et - st));
    }
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.bia_MysqlDemo1_jar_1.0-SNAPSHOTPU");

    public static void persist(Object object) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void load(int i) {

        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        try {
            em.find(NewTable.class, i);
            //em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
