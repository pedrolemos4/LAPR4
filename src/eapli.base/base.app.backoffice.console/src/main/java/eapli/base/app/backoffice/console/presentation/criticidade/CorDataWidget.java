package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

import javax.swing.*;
import java.awt.*;

public class CorDataWidget {
    /*private int r;
    private int g;
    private int b;
    
    public void show(){
        this.r = Console.readInteger("Red:");
        this.g = Console.readInteger("Green:");
        this.b = Console.readInteger("Blue:");
    }

    public int r(){
        return this.r;
    }
    
    public int g(){
        return this.g;
    }
    
    public int b(){
        return this.b;
    }*/

    private Color newColor;

    public void show() {
        newColor = null;
        while(newColor == null) {
            this.newColor = JColorChooser.showDialog(null, "Escolha um cor", Color.RED);
        }
    }

    public Color newColor(){
        return this.newColor;
    }

}
