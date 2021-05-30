package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.app.backoffice.console.presentation.servicos.FormularioDataWidget;
import eapli.base.atividade.domain.Atividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.pedido.application.SolicitarServicoController;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.*;

public class SolicitarServicoUI extends AbstractUI {

    SolicitarServicoController controller = new SolicitarServicoController();
    Scanner sc = new Scanner(System.in);

    @Override
    public boolean doShow(){
        showCatalogos();
        System.out.println("Introduza id catalogo desejado______________________________________________");
        long idCatalogo = sc.nextLong();
        showServicos(idCatalogo);
        System.out.println("Introduza codigo do servico_________________________________________________");
        String idServico = sc.next();
        try {
            solicitarServico(idServico);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
        }

    private void showCatalogos(){
        System.out.println("Catálogos disponiveis________________________________________________________");
        for (Catalogo c : controller.displayAvailableCatalogos()) {
            System.out.println("ID " + c.identity() + " | " + c.titulo()+"\n");
        }
    }

    private void showServicos(long idCatalogo){
        Iterable<Servico> servicos = controller.getServicosCatalogo(idCatalogo);
        System.out.println("Servicos disponiveis_________________________________________________________");
        if (servicos != null) {
            for (Servico s : servicos) {
                System.out.println("Codigo " + s.identity() + " | " + s.descricaoBreve());
            }
        }
    }

    private void solicitarServico(String idServico) throws IOException, InterruptedException {
        Formulario formulario = this.controller.findFormulario(idServico);

        final FormularioDataWidget formularioData = new FormularioDataWidget();
        formularioData.atributo();

        Set<Atributo> listaAtributos = new HashSet<>();
        Atributo atributo = controller.createAtributo(formularioData.nomeVariavel(), formularioData.label());
        listaAtributos.add(atributo);

        boolean flag = true;

        while (flag) {
            String resposta;
            resposta = Console.readLine("Deseja adicionar mais atributos ao formulário?\nResposta(S/N):");
            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                formularioData.atributo();
                atributo = controller.createAtributo(formularioData.nomeVariavel(), formularioData.label());
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
        calendar.set(Integer.parseInt(data1[0]),Integer.parseInt(data1[1]),Integer.parseInt(data1[2]),Integer.parseInt(horas1[0]),Integer.parseInt(horas1[1]));
        Servico clone = this.controller.getServicoClone(idServico);
        List<Atividade> atividades = this.controller.getListAtividadesServico(idServico);
        for (Atividade atividade : atividades) {
            System.out.println("Data Limite de Resolucao da Atividade(yyyy/mm/dd,hh:mm)___________________________________");
            String string2[] = sc.next().split(",");
            String data2[] = string2[0].split("/");
            String horas2[] = string2[1].split(":");
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Integer.parseInt(data2[0]),Integer.parseInt(data2[1]),Integer.parseInt(data2[2]),Integer.parseInt(horas2[0]),Integer.parseInt(horas2[1]));
            this.controller.atualizarDataAtividade(clone,atividade,calendar);
        }
        Pedido pedido = controller.efetuarPedido(clone,Enum.valueOf(UrgenciaPedido.class, urgencia.toUpperCase()),calendar,formulario,listaAtributos);
        String option = "S";
        while(option == "S") {
            System.out.println("Pretende anexar ficheiros?(S/N)_____________________________________________");
            option = sc.next();
            if (option.toUpperCase().compareTo("S") == 0)
                controller.annexFile(pedido);
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
