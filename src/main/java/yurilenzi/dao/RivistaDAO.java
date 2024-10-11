package yurilenzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import yurilenzi.entities.Libro;
import yurilenzi.entities.Rivista;

import java.util.UUID;

public class RivistaDAO {
    private final EntityManager entityManager;

    public RivistaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Rivista nuovaRivista){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(nuovaRivista);
        transaction.commit();
        System.out.println("La rivista '" + nuovaRivista.getTitolo() + "' la rivista è stata salvato correttamente");
    }

    public Rivista findById(UUID idRivista){
        Rivista found = entityManager.find(Rivista.class, idRivista);

        return found;
    }

    public void deleteById(UUID idRivista){
        Rivista found = this.findById(idRivista);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("La rivista '" + found.getTitolo() + "' è stata cancellata");
    }
}
