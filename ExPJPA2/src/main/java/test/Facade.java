/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Book;
import entity.Ebook;
import entity.PaperBook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ejer
 */
public class Facade {
    //migth want to make this into a Facade
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExPJPA2PU");
    EntityManager em = emf.createEntityManager();

// Create: persist nonspecified books, ebooks and paperbooks to database Could've been more elegant
// perhaps just give it a book instead of the attributes    
    public void addBook(Long isbn, String title, String author, double price, String Btype) {
        em.getTransaction().begin();
        Book b = new Ebook();
        b.setISBN(isbn);
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);
        em.persist(b);
        em.getTransaction().commit();
    }

    public void addEbook(Long isbn, String title, String author, double price, String url, double sizeMB) {
        em.getTransaction().begin();
        Book e = new Ebook();
        e.setISBN(isbn);
        e.setTitle(title);
        e.setAuthor(author);
        e.setDownLoadURl(url);
        e.setPrice(price);
        e.setSizeMB(sizeMB);
        em.persist(e);
        em.getTransaction().commit();

    }
    

    public void addPbook(Long isbn, String title, String author, double price, int inStock, double shippingWeight) {
        em.getTransaction().begin();
        PaperBook p = new PaperBook();
        p.setISBN(isbn);
        p.setTitle(title);
        p.setAuthor(author);
        p.setPrice(price);
        p.setInStock(inStock);
        p.setShippingWeight(shippingWeight);
        em.persist(p);
        em.getTransaction().commit();

    }

// delete if we just delete a book it should cascade to the ebook or pbook entries Polymorph example
    public void removeBookByIsbn(long isbn) {
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Book b WHERE b.ISBN=" + isbn);
        query.executeUpdate();
        em.getTransaction().commit();
    }
//Update (price is probably reasonable here
//;
//Student student = entityManager.find(Student.class,251);B
//student.setLevel("L");
//entityManager.persist(student);

    public void updatePriceByIsbn(double price, long isbn) {
        em.getTransaction().begin();
        Book b = em.find(Book.class, isbn);
        b.setPrice(price);
        em.persist(b);
        em.getTransaction().commit();
    }

    public List<Book> fetchAllBooks() {

        Query q = em.createQuery("select b  from Book b");
        List<Book> books = q.getResultList();
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Title " + (i + 1) + ": " + books.get(i).getTitle() + "  type: "
                    + books.get(i).getClass().getTypeName());
        }
        return books;

    }

    // made this mathod to get only ebooks
    public List<Book> fetchAllEBooks() {

        Query q = em.createQuery("select b from Ebook b ");
        List<Book> ebooks = q.getResultList();
        for (int i = 0; i < ebooks.size(); i++) {
            System.out.println("Title " + (i + 1) + ": " + ebooks.get(i).getTitle());
        }
        return ebooks;

    }

    public List<Book> getBookByTitle(String title) {
        Query q = em.createQuery("select b from Book b where b.title=" + title);
        List<Book> b = q.getResultList();
        return b;
    }
}
