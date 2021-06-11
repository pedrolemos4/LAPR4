package eapli.base.app.portal.console.presentation.pedido;

import eapli.base.app.backoffice.console.presentation.servicos.FormularioDataWidget;
import eapli.base.atividade.domain.Atividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.pedido.application.SolicitarServicoController;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;
import java.util.*;

public class SolicitarServicoUI extends AbstractUI {

    SolicitarServicoController controller = new SolicitarServicoController();
    Scanner sc = new Scanner(System.in);

    @Override
    public boolean doShow(){
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

    private Long showCatalogos(){
        final List<Catalogo> catalogos = controller.displayAvailableCatalogos();
        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos",catalogos,visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
        System.out.println("\nSelecione o catálogo a que pertence o serviço:");
        selector.show();
        final Catalogo theCatalogo = selector.selectedElement();
        return theCatalogo.identity();
    }

    private CodigoUnico showServicos(long idCatalogo){
        Iterable<Servico> servicos = controller.getServicosCatalogo(idCatalogo);
        final SelectWidget<Servico> selector = new SelectWidget<>("Serviços",servicos,visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
        System.out.println("\nSelecione o catálogo a que pertence o serviço:");
        selector.show();
        final Servico theServico = selector.selectedElement();
        return theServico.identity();
    }

    private void solicitarServico(CodigoUnico idServico) throws IOException, InterruptedException {
        Formulario formulario = new Formulario(this.controller.findFormulario(idServico));

        final FormularioDataWidget formularioData = new FormularioDataWidget();
        formularioData.atributo();

        System.out.println(formularioData.nomeVariavel());
        System.out.println(formularioData.label());
        Set<Atributo> listaAtributos = new HashSet<>();
        Atributo atributo = controller.createAtributo(formularioData.nomeVariavel(), formularioData.label(), formulario);
        listaAtributos.add(atributo);

        boolean flag = true;

        while (flag) {
            String resposta;
            resposta = Console.readLine("Deseja adicionar mais atributos ao formulário?\nResposta(S/N):");
            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                formularioData.atributo();
                atributo = controller.createAtributo(formularioData.nomeVariavel(), formularioData.label(), formulario);
                listaAtributos.add(atributo);
            } else {
                flag = false;
            }
        }

        System.out.println("Urgencia____________________________________________________________________");
        for (UrgenciaPedido u : UrgenciaPedido.values()) {
            System.out.println(u);
        }
        System.out.println("Introduza Urgencia");
        String urgencia = sc.next();
        System.out.println("Data Limite de Resolucao(yyyy/mm/dd,hh:mm)________________________________________");
        String string1[] = sc.next().split(",");
        String data1[] = string1[0].split("/");
        String horas1[] = string1[1].split(":");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(data1[0]),Integer.parseInt(data1[1])-1,Integer.parseInt(data1[2]),Integer.parseInt(horas1[0]),Integer.parseInt(horas1[1]));
        Servico clone = this.controller.getServicoClone(idServico);
        List<Atividade> atividades = this.controller.getListAtividadesServico(idServico);
        for (Atividade atividade : atividades) {
            System.out.println("Data Limite de Resolucao da Atividade(yyyy/mm/dd,hh:mm)___________________________________");
            String string2[] = sc.next().split(",");
            String data2[] = string2[0].split("/");
            String horas2[] = string2[1].split(":");
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Integer.parseInt(data2[0]),Integer.parseInt(data2[1])-1,Integer.parseInt(data2[2]),Integer.parseInt(horas2[0]),Integer.parseInt(horas2[1]));
            this.controller.atualizarDataAtividade(clone,atividade,calendar1);
        }
        Pedido pedido = controller.efetuarPedido(clone,Enum.valueOf(UrgenciaPedido.class, urgencia.toUpperCase()),calendar,formulario,listaAtributos);
        String option = "S";
        while(option == "S") {
            System.out.println("Pretende anexar ficheiros?(S/N)_____________________________________________");
            option = sc.next();
            if (option.toUpperCase().compareTo("S") == 0){
                controller.annexFile(pedido);
            }
        }
        //if(controller.submeterPedido(pedido)){
        controller.doConnection(pedido);
            System.out.println("SUCESSO");
        //}
    }


    @Override
    public String headline() {
        return "SolicitarServico";
    }


}
