package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.framework.domain.repositories.DomainRepository;

public interface CatalogoRepository extends DomainRepository<Long, Catalogo> {

    Iterable<Catalogo> findByTitulo(String titulo);

    Iterable<Catalogo> findByDescricaoCompleta(String descricaoCompleta);

    Iterable<Catalogo> findByDescricaoBreve(String descricaoBreve);

    Iterable<Catalogo> findByTituloDescricaoBreve(String titulo, String descricaoCompleta);

    Iterable<Catalogo> findByTituloDescricaoCompleta(String titulo, String descricaoCompleta);

    Iterable<Catalogo> findByDescricaoBreveDescricaoCompleta(String descricaoBreve, String descricaoCompleta);

    Iterable<Catalogo> findTodos(String titulo, String descricaoBreve, String descricaoCompleta);
}
