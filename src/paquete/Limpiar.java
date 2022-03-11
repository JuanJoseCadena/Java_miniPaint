package paquete;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Limpiar extends Ventana {
    
    public static void Limpia()
    {
        limpiar.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    	img=new BufferedImage(760,420,BufferedImage.TYPE_INT_ARGB);
                    	if(Cargar.img2==null) 
                    	{
                    		graph=img.createGraphics();
                        	graph.setColor(Color.white);
                			graph.fillRect(0, 0, img.getWidth(), img.getHeight());
                    	}
                    	
                    	panel.repaint();
                    }
                });
    }
}
