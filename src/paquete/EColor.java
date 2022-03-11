package paquete;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

public class EColor extends JDialog implements ActionListener{

    JColorChooser escoger = new JColorChooser();
    JButton aceptar = new JButton("Aceptar");
    Dibujar aux;
    
    EColor(Dibujar col)
    {
        aux=col;
        aceptar.addActionListener(this);
        add(aceptar);
        add(escoger);
        setLayout(new FlowLayout());
        setSize(700,530);
        setTitle("Color");
        setVisible(true);
        setLocation(220,100);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==aceptar)
        {
            aux.nuevocolor = escoger.getColor();
        }
        dispose();
    }
}
