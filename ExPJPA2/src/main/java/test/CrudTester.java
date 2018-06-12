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
 * @author BenedikteEva
 */
public class CrudTester {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExPJPA2PU");
        EntityManager em = emf.createEntityManager();
        Facade ct = new Facade();
        try {

            ct.addEbook(9788799516520L, "Book of Magic in Practice", "BenedikteEva", 49.95, "https://www.saxo.com/dk/book-of-magic-in-practice_pdf_9788799516520", 1.75);
            ct.addEbook(9788792562623L, "Life of a Magician", "BenedikteEva", 39.95, "https://www.saxo.com/dk/life-of-a-magician-with-magical-contact-lenses_pdf_9788792562623", 1.40);
            ct.addEbook(9788740461626L, "Considerations of Magic - Philosophical, Personal and Historical ", "BenedikteEva", 10.00, "https://www.saxo.com/dk/considerations-of-magic-philosophical-personal-and-historical_pdf_9788740461626", 1.29);
            ct.addPbook(9781492819523L, "Considerations of Magic - Philosophical, Personal and Historical ", "BenedikteEva", 49.95, 9, 127.56);
            ct.updatePriceByIsbn(59.95, 9788799516520L);

            System.out.println("The next is to demonstrate polymorphism and cascade delete\n"
                    + "Please notice that the book from the fetchAllBooks list is removed from both\n"
                    + "the book list and the ebook list because ebook is a subclass of book");
            ct.fetchAllBooks();
            ct.fetchAllEBooks();
            ct.removeBookByIsbn(9788740461626L);
            ct.fetchAllBooks();
            ct.fetchAllEBooks();
            //adding the removed book back
            ct.addEbook(9788740461626L, "Considerations of Magic - Philosophical, Personal and Historical ", "BenedikteEva", 10.00, "https://www.saxo.com/dk/considerations-of-magic-philosophical-personal-and-historical_pdf_9788740461626", 1.29);
            //Get book by title læg lige mærke til at en af mine bøger er udgivet som både p og e bog og dermed har forskellige isbn
            System.out.println(ct.getBookByTitle("'Book of Magic in Practice'"));
            System.out.println(ct.getBookByTitle("'Considerations of Magic - Philosophical, Personal and Historical '"));
        } finally {
            em.close();
        }
    }
}
