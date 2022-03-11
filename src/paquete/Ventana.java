package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class Ventana extends JFrame{
        
	static BufferedImage img=new BufferedImage(760, 420, BufferedImage.TYPE_INT_ARGB);
	static Graphics2D graph = img.createGraphics();
    static JFrame cuadro = new JFrame("MiniPaint");
	static Font fuente = new Font("Avenir Negra",Font.PLAIN,12);
    static JButton color = new JButton("Color del pincel");
    static JButton limpiar = new JButton("Limpiar");
    static JLabel grosor = new JLabel("Grosor del pincel");
    static JPanel panel = new JPanel()
    {
    	@Override
    	protected void paintComponent(Graphics g) 
    	{
    		super.paintComponent(g);
    		graph.setColor(Color.white);
			graph.fillRect(0, 0, img.getWidth(), img.getHeight());
    		graph = (Graphics2D) g.create();
    		if (Cargar.img2 ==null) 
    		{
    			graph.setColor(Color.white);
    			graph.fillRect(0, 0, img.getWidth(), img.getHeight());
    		}
    		else 
    		{
    			graph.drawImage(Cargar.img2, 0 , 0, img.getWidth(), img.getHeight(), null);
    		}
        	graph.drawImage(img, 0, 0,img.getWidth(),img.getHeight(), null);
            graph.setColor(Color.black);
            graph.dispose();
            repaint();
    		
    	}
    };
    static JSlider desgrosor = new JSlider();
    static Dibujar pincel = new Dibujar();
    
    
    public static void CrearVentana()
    {
    	graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        cuadro.setLocation(400,200);
        cuadro.setSize(790,615);
        cuadro.setResizable(false);
        cuadro.addWindowListener(new WindowAdapter() 
        {
        	public void windowClosing (WindowEvent e) 
        	{
        		System.exit(0);
        	}
        });
    	InicioComponentes();
    	MenuBar.Barra();
        cuadro.setVisible(true);
    }


    public static void InicioComponentes()
    {
        cuadro.getContentPane().setLayout(null);
        cuadro.setDefaultCloseOperation(EXIT_ON_CLOSE);
        color.setBounds(20,80,150,25);
        color.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new EColor(pincel);
            }
            
        });
        limpiar.setBounds(610,80,150,25);
        Limpiar.Limpia();
        grosor.setFont(fuente);
        grosor.setBounds(330,55,100,25);
        desgrosor.setMaximum(10);
        desgrosor.setBounds(300,80,150,25);
        panel.setBounds(12, 130, 760, 420);
        panel.setOpaque(true);
        panel.setBackground(Color.white);
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        Dibujar.Eventos();
        cuadro.getContentPane().add(color);
        cuadro.getContentPane().add(limpiar);
        cuadro.getContentPane().add(grosor);
        cuadro.getContentPane().add(desgrosor);
        cuadro.getContentPane().add(panel);
    }
    

}
