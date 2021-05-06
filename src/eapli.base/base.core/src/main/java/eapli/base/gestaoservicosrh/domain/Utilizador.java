package eapli.base.gestaoservicosrh.domain;



import eapli.base.gestaoservicoshelpdesk.domain.Identificador;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Utilizador implements AggregateRoot<Identificador> {

    @Version
    private Long version;

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FUNCAO")
    private TipoUtilizador role;

    public Utilizador(int id, String email, String password, TipoUtilizador role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Utilizador() {
        //ORM
    }

    public boolean addUser(Utilizador utilizador){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(utilizador);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Identificador identity() {
        return null;
    }
}
