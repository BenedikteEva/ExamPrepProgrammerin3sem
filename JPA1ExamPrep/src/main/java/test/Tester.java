/*

 */
package test;

import entities.Customer;
import entities.ItemType;
import entities.OrderLine;
import entities.Ordre;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ejer
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.BenedikteEva_JPA1ExamPrep_jar_1.0-SNAPSHOTPU2");
        EntityManager em = emf.createEntityManager();
        Customer c = new Customer("Hans Gertrud Andersen", "hga@trans.dk");
        Customer c1 = new Customer("Winnie the Pu", "pu@pu.pu");
        ItemType it1 = new ItemType("dims", "en dims der gør et eller andet",9.95);
       ItemType it2 = new ItemType("dingenot","dingenot der gør noget andet end en dims",19.95);
       ItemType it3 = new ItemType("himstregims", "have no idea",324.86);
       Ordre o=new Ordre(c);
               Ordre o1=new Ordre(c);
          OrderLine ol1=new OrderLine(4,it3,o);
       OrderLine ol2=new OrderLine(2,it2, o);
       OrderLine ol3=new OrderLine(10,it1,o1);
          em.getTransaction().begin();
       entities.Facade.addAnItem(em, it1);
         entities.Facade.addAnItem(em, it2);
        entities.Facade.addAnItem(em, it3);  
        entities.Facade.createCustomer(em, c);
        entities.Facade.createCustomer(em, c1);   
        entities.Facade.createanOrder(em, o);
        entities.Facade.createanOrder(em, o1);
       entities.Facade.addOrderLine(em, ol2);
       entities.Facade.addOrderLine(em, ol1);
       entities.Facade.addOrderLine(em, ol3);
       
        em.getTransaction().commit();
     
//        entities.Facade.addOrderLines(em, Long.MIN_VALUE, ols);
        System.out.println(entities.Facade.getAllCustomers(em));
        System.out.println(entities.Facade.findCustomerById(em, 1L).getName());
        System.out.println(entities.Facade.getOrdreById(em, 1L));
        System.out.println(entities.Facade.getOrderDetailsByOrderID(em, 1L));
        System.out.println("list tak"+entities.Facade.getOrdrerByCustId(em, 2L));
        em.close();
    }
}
