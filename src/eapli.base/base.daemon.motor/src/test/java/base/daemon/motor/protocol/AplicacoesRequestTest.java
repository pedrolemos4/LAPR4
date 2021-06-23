/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.daemon.motor.protocol;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.EstadoFluxo;
import eapli.base.atividade.domain.FluxoAtividade;
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
        public List<Atividade> getNTarefasPendentes (MecanographicNumber userId, EstadoAtividade estado){
            return new ArrayList<>();
        }

        @Override
        public List<Atividade> getTarefasQueUltrapassamDataPedido (MecanographicNumber userId, EstadoAtividade estado){
            return new ArrayList<>();
        }

        public List<Atividade> getTarefasQueTerminamEm1Hora (MecanographicNumber userId, EstadoAtividade estado,int hours){
            return new ArrayList<>();
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
            public List<Atividade> getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public List<Atividade> getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalArgumentException("Unknown");
            }

            @Override
            public List<Atividade> getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
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

        });
    }


    protected void setMockControllerThrow() {
        // MOCK controller
        AplicacoesMessageParser.injectController(new AplicacoesController() {

            @Override
            public EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public List<Atividade> getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public List<Atividade> getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
                throw new IllegalStateException(NOT_IMPLEMENTED_YET);
            }

            @Override
            public List<Atividade> getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
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


        });
    }

    protected abstract String[] getSemanticErrorFixtures();


}
