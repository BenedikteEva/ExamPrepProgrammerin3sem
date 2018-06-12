package entities;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Implement a simple facade class with a method that will return all Pet's, and
 * demonstrate the method
 *
 * @author Ejer
 */
public class PetFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.BenedikteEva_RestAndApiExamRecap_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    Pet p = new Pet();

    public static HashMap<Integer, Event> events = new HashMap<>();

    public static Owner findOwnerById(Owner ownerId) {
        return null;

    }

  

    public List<Pet> getAllPets() {
        List<Pet> pets;
        Query q = em.createQuery("select p from Pet p");
        pets = q.getResultList();
        return pets;
    }

    public Integer petCount() {
        return getAllPets().size();
    }

}
