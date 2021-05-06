package eapli.base.usermanagement.domain;



import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;


import javax.persistence.*;

@Entity
@Table(name="UTILIZADOR")
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilizador implements AggregateRoot<MecanographicNumber> {

    @Version
    private Long version;

    @Id
    @Column(name = "ID_UTILIZADOR")
    private MecanographicNumber id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FUNCAO")
    private TipoUtilizador role;

    public Utilizador(MecanographicNumber id, String email, String password, TipoUtilizador role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Utilizador() {
        //ORM
    }

    public boolean addUser(Utilizador utilizador) {
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
    public MecanographicNumber identity() {
        return null;
    }

}
