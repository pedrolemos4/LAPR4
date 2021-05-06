package eapli.base.usermanagement.domain;



import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Password;


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
    private EmailAddress email;

    @Column(name = "PASSWORD")
    private Password password;

    @Column(name = "FUNCAO")
    private TipoUtilizador role;

    public Utilizador(MecanographicNumber id, EmailAddress email, Password password, TipoUtilizador role) {
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
