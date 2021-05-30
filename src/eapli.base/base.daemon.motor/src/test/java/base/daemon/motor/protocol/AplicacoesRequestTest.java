/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.EstadoFluxo;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.pedido.domain.UrgenciaPedido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author beatriz
 */
public abstract class AplicacoesRequestTest {

    private static final Logger LOGGER = LogManager.getLogger(AplicacoesRequestTest.class);

    protected static final String NOT_IMPLEMENTED_YET = "not implemented yet";

    protected void setMockControllerNoData() {
        // MOCK controller
        AplicacoesMessageParser.injectController(new AplicacoesController() {
            @Override
            public EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId) {
                return EstadoFluxo.PENDENTE;
            }

        });
    }

    protected void setMockControllerNoData1() {

        AplicacoesMessageParser.injectController(new AplicacoesController() {
        @Override
        public Long getNTarefasPendentes (MecanographicNumber userId, EstadoAtividade estado){
            return Long.valueOf(0);
        }

        @Override
        public Long getTarefasQueUltrapassamDataPedido (MecanographicNumber userId, EstadoAtividade estado){
            return Long.valueOf(0);
        }

        public Long getTarefasQueTerminamEm1Hora (MecanographicNumber userId, EstadoAtividade estado,int hours){
            return Long.valueOf(0);
        }

        public List<Atividade> getTarefasUrgencia (MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido
        urgenciaReduzida){
            return new ArrayList<>();
        }

        public List<Atividade> getTarefaEscala (MecanographicNumber userId, EstadoAtividade estado,int i){
            return new ArrayList<>();
        }

        public List<Atividade> getTarefaEtiqueta (MecanographicNumber userId, EstadoAtividade estado, String etiqueta){
            return new ArrayList<>();
        }

        public FluxoAtividade getFluxoAtividade (String idServico){
            return new FluxoAtividade(new HashSet<>());
        }

    });
}

    protected void setMockControllerUnknowns() {
        // MOCK controller
        AplicacoesMessageParser.injectController(new AplicacoesController() {
            @Override
            public EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public Long getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public Long getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public Long getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public List<Atividade> getTarefasUrgencia(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaReduzida) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public List<Atividade> getTarefaEscala(MecanographicNumber userId, EstadoAtividade estado, int i) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public List<Atividade> getTarefaEtiqueta(MecanographicNumber userId, EstadoAtividade estado, String etiqueta) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public FluxoAtividade getFluxoAtividade(String idServico) {
                throw new IllegalArgumentException("Unknown");
            }


        });
    }

    /*protected void setMockController1RowOfData() {
        // MOCK controller
        AplicacoesMessageParser.injectController(new AplicacoesController() {
            @Override
            public Iterable<Meal> getMealsOfADay(final Calendar when, final MealType forMeal) {
                final DishType dt = new DishType("fish", "fish");
                final Dish d1 = new Dish(dt, Designation.valueOf("bacalhau"), Money.euros(7.95));
                final List<Meal> results = new ArrayList<>();
                results.add(new Meal(MealType.LUNCH, Calendars.now(), d1));
                return results;
            }

            @Override
            public BookingToken bookMeal(final Meal meal, final CafeteriaUser booker) {
                return new BookingToken();
            }

            @Override
            public BookingToken bookMeal(final Long mealId, final MecanographicNumber booker) {
                return new BookingToken();
            }
        });
    }*/

    protected void setMockControllerThrow() {
        // MOCK controller
        AplicacoesMessageParser.injectController(new AplicacoesController() {

            @Override
            public EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public Long getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public Long getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public Long getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public List<Atividade> getTarefasUrgencia(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaReduzida) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public List<Atividade> getTarefaEscala(MecanographicNumber userId, EstadoAtividade estado, int i) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public List<Atividade> getTarefaEtiqueta(MecanographicNumber userId, EstadoAtividade estado, String etiqueta) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public FluxoAtividade getFluxoAtividade(String idServico) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }


        });
    }

    /*@Test
    public void ensureBadRequest() throws ParseException {
        final String[] fixtures = getSemanticErrorFixtures();
        for (int i = 0; i < fixtures.length; i++) {
            LOGGER.info("Testing for BAD_REQUEST #{}: {}", i, fixtures[i]);
            ensureBadRequest(fixtures[i]);
        }
        LOGGER.info("Testing for BAD_REQUEST - All clear");
    }*/

    protected abstract String[] getSemanticErrorFixtures();

    /*public void ensureBadRequest(final String msg) throws ParseException {

        final AplicacoesRequest req = AplicacoesMessageParser.parse(msg);

        final String result = req.execute();
        LOGGER.info("{} -> {}", msg, result);

        final String[] tokens = CsvLineMarshaler.tokenize(result).toArray(new String[0]);
        assertEquals(4, tokens.length);
        assertEquals("BAD_REQUEST", tokens[0]);
        // assertEquals("\"" + unescapeQuotes(msg) + "\"", tokens[1]);
        assertEquals("", tokens[3]);// \n
        assertEquals('\n', result.charAt(result.length() - 1));
    }

    protected abstract String getSampleOkRequest();

    @Test
    public void ensureServerErrorOnThrows() throws ParseException {

        setMockControllerThrow();

        final AplicacoesRequest req = AplicacoesMessageParser
                .parse(getSampleOkRequest());

        final String result = req.execute();
        LOGGER.info("{} -> {}", getSampleOkRequest(), result);

        final String[] lines = result.split("\n");
        assertEquals(1, lines.length);

        final String[] tokens = CsvLineMarshaler.tokenize(lines[0]).toArray(new String[0]);
        assertEquals(3, tokens.length);
        assertEquals("SERVER_ERROR", tokens[0]);
        assertEquals("\"" + NOT_IMPLEMENTED_YET + "\"", tokens[2]);
        assertEquals('\n', result.charAt(result.length() - 1));
    }*/

}
