package eapli.base.app.backoffice.console.presentation.criticidade;

import javax.swing.*;
import java.awt.*;

public class CorDataWidget {

    private Color newColor;

    public void show() {
        newColor = null;
        while(newColor == null) {
            this.newColor = JColorChooser.showDialog(null, "Escolha uma cor", Color.RED);
        }
    }

    public Color newColor(){
        return this.newColor;
    }

}
