package paquete;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


import java.awt.Color;


import paquete.Ventana;

public class Dibujar extends Ventana{

    static Color nuevocolor = new Color(0,0,0);
    static int x;
    static int y;
    static BufferedImage bimage;
    static BufferedImage orim;
    static Graphics2D grafico;
    
    
    public void Leer(MouseEvent ev)
    {
        if(!ev.isMetaDown())
        {
            x=ev.getX();
            y=ev.getY();
        } 
    }
    
    public void Dibuja(MouseEvent ev, int grueso)
    {
    	
        if(!ev.isMetaDown())
        {
        	grafico = (Graphics2D) img.getGraphics();
            ((Graphics2D) grafico).setStroke(new BasicStroke(grueso));
            grafico.setColor(nuevocolor);
            int x2=ev.getX();
            int y2=ev.getY();
            grafico.drawLine(x,y,x2,y2);
            x=x2;
            y=y2;
			grafico.dispose();


            
        }
        else if(ev.isMetaDown())
        {
            grafico = (Graphics2D) img.getGraphics();
            ((Graphics2D) grafico).setStroke(new BasicStroke(grueso));
            grafico.setColor(Color.white);
            grafico.drawLine(ev.getX(),ev.getY(),ev.getX(),ev.getY());

        }
    }
        
    
    public static void Eventos()
    {
        panel.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                pincel.Leer(e);
            }
        });
    
        panel.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                pincel.Dibuja(e, desgrosor.getValue());
            }
        });
    }
}
