package yurilenzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import yurilenzi.entities.Utente;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

public class UtenteDAO {
    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Utente nuovoUtente){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(nuovoUtente);
        transaction.commit();
        System.out.println("L'utente '" + nuovoUtente.getNome() + "' è stato salvato correttamente");
    }

    public Utente findById(long idUtente){
        Utente found = entityManager.find(Utente.class, idUtente);
        return found;
    }

    public void deleteById(long idUtente){
        Utente found = this.findById(idUtente);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("L'utente '" + found.getNome() + "' è stato cancellato");
    }

    public void viewUserDb(){
        TypedQuery<Utente> query = entityManager.createQuery("select u from Utente u", Utente.class);
        List<Utente> resultList = query.getResultList();
        resultList.forEach(System.out::println);

    }
}
