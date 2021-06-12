package eapli.base.app.portal.console.presentation.pedido;

import eapli.base.app.backoffice.console.presentation.servicos.FormularioDataWidget;
import eapli.base.atividade.domain.Atividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Variavel;
import eapli.base.pedido.application.SolicitarServicoController;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;
import java.text.Normalizer;
import java.util.*;

public class SolicitarServicoUI extends AbstractUI {

    SolicitarServicoController controller = new SolicitarServicoController();
    Scanner sc = new Scanner(System.in);

    @Override
    public boolean doShow() {
        long idCatalogo = showCatalogos();
        CodigoUnico idServico = showServicos(idCatalogo);
        try {
            solicitarServico(idServico);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    private Long showCatalogos() {
        final List<Catalogo> catalogos = controller.displayAvailableCatalogos();
        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos", catalogos, visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
        System.out.println("\nSelecione o catálogo a que pertence o serviço:");
        selector.show();
        final Catalogo theCatalogo = selector.selectedElement();
        return theCatalogo.identity();
    }

    private CodigoUnico showServicos(long idCatalogo) {
        Iterable<Servico> servicos = controller.getServicosCatalogo(idCatalogo);
        final SelectWidget<Servico> selector = new SelectWidget<>("Serviços", servicos, visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
        System.out.println("\nSelecione o catálogo a que pertence o serviço:");
        selector.show();
        final Servico theServico = selector.selectedElement();
        return theServico.identity();
    }

    private void solicitarServico(CodigoUnico idServico) throws IOException, InterruptedException {
        Set<Atributo> listaAtributos = new HashSet<>();
        Formulario formulario = preencherAtributos(this.controller.findFormulario(idServico), listaAtributos);
        System.out.println("wtf");
        UrgenciaPedido urgencia = selectUrgencia();
        System.out.println("Data Limite de Resolucao(yyyy/mm/dd,hh:mm)________________________________________");
        Calendar calendar = setData();
        Servico clone = this.controller.getServicoClone(idServico);
        List<Atividade> atividades = this.controller.getListAtividadesServico(idServico);
        for (Atividade atividade : atividades) {
            System.out.println("Data Limite de Resolucao da Atividade(yyyy/mm/dd,hh:mm)___________________________________");
            Calendar calendar1 = setData();
            this.controller.atualizarDataAtividade(clone, atividade, calendar1);
        }
        Pedido pedido = controller.efetuarPedido(clone, urgencia, calendar, formulario, listaAtributos);
        String option = "S";
        while (option == "S") {
            System.out.println("Pretende anexar ficheiros?(S/N)_____________________________________________");
            option = sc.next();
            if (option.toUpperCase().compareTo("S") == 0) {
                controller.annexFile(pedido);
            }
        }
        //if(controller.submeterPedido(pedido)){
        controller.doConnection(pedido);
        System.out.println("SUCESSO");
        //}
    }

    private Formulario preencherAtributos(Formulario formulario1, Set<Atributo> listaAtributos) {
        System.out.println("linha 89");
        List<Atributo> listaAtributosForm = controller.findAtributos(formulario1.identity());
        Formulario formulario = new Formulario(formulario1);
        System.out.println("Size" + listaAtributosForm.size());
        for (Atributo a : listaAtributosForm) {
            System.out.println("Label: " + controller.label(a));
            String variavel = Console.readLine("Introduza o nome da variável correspondente: ");
            Atributo atributo = controller.createAtributo(variavel, controller.label(a), controller.tipoDados(a),
                    controller.obrigatoriedade(a), controller.descricaoAjuda(a), formulario);
            listaAtributos.add(atributo);
        }
        return formulario;
    }

    public Calendar setData() {
        try {
            String string1[] = sc.next().split(",");
            String data1[] = string1[0].split("/");
            String horas1[] = string1[1].split(":");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(data1[0]), Integer.parseInt(data1[1]) - 1, Integer.parseInt(data1[2]), Integer.parseInt(horas1[0]), Integer.parseInt(horas1[1]));
            return calendar;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Insira a data corretamente\n");
            System.out.println("\nData (yyyy/mm/dd,hh:mm)________________________________________");
            setData();
        } catch (NumberFormatException ex) {
            System.out.println("Insira a data corretamente\n");
            System.out.println("\nData (yyyy/mm/dd,hh:mm)________________________________________");
            setData();
        }
        return null;
    }

    public UrgenciaPedido selectUrgencia() {
        try {
            System.out.println("\nUrgencia____________________________________________________________________");
            for (UrgenciaPedido u : UrgenciaPedido.values()) {
                System.out.println(u);
            }
            System.out.println("Introduza Urgencia");
            String urgencia = sc.next();
            return Enum.valueOf(UrgenciaPedido.class, urgencia.toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("Escolha um nível válido de urgência\n");
            selectUrgencia();
        }
        return null;
    }

    @Override
    public String headline() {
        return "SolicitarServico";
    }


}
