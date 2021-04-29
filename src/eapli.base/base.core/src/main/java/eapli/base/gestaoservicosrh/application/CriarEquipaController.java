package eapli.base.gestaoservicosrh.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;

public class CriarEquipaController {

    private final EquipaRepository repo = (EquipaRepository) PersistenceContext.repositories().clientUsers();

}
