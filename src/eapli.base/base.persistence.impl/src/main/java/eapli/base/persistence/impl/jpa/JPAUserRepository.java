package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Utilizador;
import eapli.base.usermanagement.domain.repositories.UserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class JPAUserRepository
        extends JpaAutoTxRepository<Utilizador,MecanographicNumber,MecanographicNumber>
        implements UserRepository {


    public JPAUserRepository(TransactionalContext autoTx) {
        super(autoTx, "mecanographicNumber");
    }

    public JPAUserRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "mecanographicNumber");
    }

    @Override
    public Optional<Utilizador> findByUsername(String email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", email);
        return matchOne("e.systemUser.username=:name", params);
    }

    @Override
    public Optional<Utilizador> findByMecanographicNumber(MecanographicNumber number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.mecanographicNumber=:number", params);
    }

    @Override
    public Iterable<Utilizador> findAllActive() {
        return match("e.systemUser.active = true");
    }

    @Override
    public <S extends Utilizador> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Utilizador> ofIdentity(MecanographicNumber id) {
        return Optional.empty();
    }

    @Override
    public void delete(Utilizador entity) {

    }

    @Override
    public void deleteOfIdentity(MecanographicNumber entityId) {

    }
}
