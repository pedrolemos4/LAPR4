package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.Cor;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.application.CriarEquipaController;
import eapli.base.tipoequipa.application.RegistarTipoEquipaController;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class EquipaBootstrapper implements Action {
    private static final Logger LOGGER = LogManager.getLogger(EquipaBootstrapper.class);

    private final CriarEquipaController controller = new CriarEquipaController();
    private final RegistarTipoEquipaController registarTipoEquipaController = new RegistarTipoEquipaController();

    @Override
    public boolean execute() {
        Set<FuncaoColaborador> funcao = new HashSet<>();
        funcao.add(BaseRolesColaborador.DIRETOR);
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),dataAux
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"),  EmailAddress.valueOf("joao@gmail.com"),funcao);

        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(c1);
        //registarTipoEquipaController.registarAlt(t1);
        //registarTipoEquipaController.registarTipoEquipa("t1","tipo1",10,20,30);
        register("e1","EQP1", "equipa1", t1, setCol);

        TipoEquipa t2 = new TipoEquipa(new CodigoUnico("t2"),new Designacao("tipo2"), new Cor(60,40,80));
       // registarTipoEquipaController.registarAlt(t2);
        //registarTipoEquipaController.registarTipoEquipa("t2","tipo2",60,40,80);
        Colaborador c2 = new Colaborador(new MecanographicNumber(119876),new ShortName("Gustavo"),new FullName("Gustavo Mike White"),dataAux
                ,new Contacto(932705057),new LocalResidencia("Bairro Alto"), EmailAddress.valueOf("gustavo@gmail.com"),funcao);

        Set<Colaborador> setCol2 = new HashSet<>();
        setCol2.add(c1);
        setCol2.add(c2);

        register("e2","EQP2", "equipa2", t2, setCol2);
        return true;
    }

    private void register(final String cod, final String acronimo, final String desig, final TipoEquipa tipo, final Set<Colaborador> responsaveis) {
        try {
            controller.novaEquipa(cod,acronimo,desig,tipo,responsaveis);
            LOGGER.info(cod);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", cod);
            LOGGER.trace("Assuming existing record", e);
        }
    }
}
