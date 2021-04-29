package gestaoservicosrh.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import gestaoservicosrh.repositories.EquipaRepository;

public class CriarEquipaController {

    private final EquipaRepository repo = (EquipaRepository) PersistenceContext.repositories().clientUsers();
    
}
