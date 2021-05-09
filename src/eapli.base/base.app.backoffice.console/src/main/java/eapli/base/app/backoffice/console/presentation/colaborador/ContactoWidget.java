package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.io.util.Console;

public class ContactoWidget {

    private int value;
    private int prefix;

    public void show(){
        String s = Console.readLine("Contacto:");
        if(s.length()==9){
            this.value=Integer.parseInt(s);
            this.prefix=0;
        }else{
            String split[] = s.split(" ");
            this.value=Integer.parseInt(split[1]);
            this.prefix=Integer.parseInt(split[0]);
        }
    }

    public int contact(){
        return this.value;
    }

    public int prefix(){
        return this.prefix;
    }

}
