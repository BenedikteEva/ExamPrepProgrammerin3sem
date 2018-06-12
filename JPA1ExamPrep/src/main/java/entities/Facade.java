/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static entities.Customer_.email;
import static entities.Customer_.name;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ejer
 */
public class Facade {

    public static void createCustomer(EntityManager em, Customer c) {
        em.persist(c);
    }

    public static Customer findCustomerById(EntityManager em, long customerId) {
        Customer c = em.find(Customer.class, customerId);
        return c;
    }

    public static List<Customer> getAllCustomers(EntityManager em) {
        List<Customer> customers;
        Query q = em.createQuery("select c from Customer c");
        customers = q.getResultList();
        return customers;
    }
    
    public static void createanOrder(EntityManager em, Ordre o){
        em.persist(o);
    }
    public static Ordre getOrdreById(EntityManager em, Long id){
Ordre orders;
        Query q = em.createQuery("select o from Ordre o where o.id=:id");
        q.setParameter("id", id);
       orders=(Ordre) q.getSingleResult();
        return orders;
    }
    public static Long getLastOrderId(EntityManager em){
        em.createQuery("select max(o.id) from Ordre o", Integer.class).getSingleResult();
        return  em.createQuery("select max(o.id) from Ordre o", Long.class).getSingleResult();
    }
    
    public static String getOrderDetailsByOrderID(EntityManager em, Long id){
        Ordre o=getOrdreById(em,id);
        Customer c=getCustomerByOrdreId(em,id);
        List<OrderLine>ols=getOrdreLinesByOrderId(em,o);
                return ("Order no: "+o.getId()+" Customer: "+c.getName()+" OrderLines: "+ols);
    }
    public static void addAnItem(EntityManager em,ItemType item ){

       em.persist(item);
        
    }
    public static void addOrderLine(EntityManager em,OrderLine ol){
        
     em.persist(ol); 
    }
    
    public static List<OrderLine>getOrdreLinesByOrderId(EntityManager em, Ordre ordreId){
        List<OrderLine>ordreLines;
        
        Query q = em.createQuery("select o from OrderLine o where o.OrderId=:ordreId");
        q.setParameter("ordreId", ordreId);
       ordreLines= q.getResultList();
        return ordreLines;
     }

    private static Customer getCustomerByOrdreId(EntityManager em, Long ordreid) {
        Customer cust;
        Query q = em.createQuery("select o.customer from Ordre o where o.id=:id");
        q.setParameter("id", ordreid);
       cust =(Customer) q.getSingleResult();
        return cust;
    }

    public static List<Ordre> getOrdrerByCustId(EntityManager em, Long CustID){
                List<Ordre>orders;
                Customer cust= findCustomerById(em,CustID);
             Query q = em.createQuery("select o from Ordre o where o.customer=:cust");
          q.setParameter("cust", cust);
         orders= q.getResultList();
         return orders;
    }
}
