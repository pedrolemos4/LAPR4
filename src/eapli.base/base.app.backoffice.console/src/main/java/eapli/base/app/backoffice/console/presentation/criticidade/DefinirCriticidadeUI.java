package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.base.gestaoservicoshelpdesk.application.DefinirCriticidadeController;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.CriticidadeRepository;
import eapli.framework.io.util.Console;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DefinirCriticidadeUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(DefinirCriticidadeUI.class);

    private final DefinirCriticidadeController controller = new DefinirCriticidadeController();

    @Override
    protected boolean doShow() {
        
        boolean flag = true;
        
        System.out.println("Introduza os dados relativos aos níveis de criticidade:");
        while (flag == true){
        final ObjetivoDataWidget obj = new ObjetivoDataWidget();
        obj.show();

        final EtiquetaDataWidget et = new EtiquetaDataWidget();
        et.show();
        
        final EscalaDataWidget esc = new EscalaDataWidget();
        esc.show();
        
        final CorDataWidget c = new CorDataWidget();
        c.show();
        
        final DesignacaoDataWidget desig = new DesignacaoDataWidget();
        desig.show();
        
        try{
            this.controller.defineCriticidade(obj.tempoMax(), obj.tempoMedio()
                    , et.etiqueta(), esc.escala(),  c.newColor()/*c.r(), c.g(), c.b()*/, desig.designacao());
        } catch (final IntegrityViolationException e) {
            System.out.println("Erro.");
        }
        String answer = Console.readLine("Deseja adicionar mais niveis de criticidade (S/N)?");
            if("N".equalsIgnoreCase(answer)){
                flag = false;
            }
        }
        
        System.out.println("Introduza os dados relativos ao Contrato SLA:");
        
        final DesignacaoDataWidget desig = new DesignacaoDataWidget();
        desig.show();
        
        this.controller.defineContrato(desig.designacao());

        return false;
    }

    @Override
    public String headline() {
        return "Definir Criticidade";
    }
}
