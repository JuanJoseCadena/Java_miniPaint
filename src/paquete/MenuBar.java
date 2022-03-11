package paquete;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class MenuBar extends Ventana implements ActionListener{

	static JMenuBar BarraMenu = new JMenuBar();
	static JMenu MenuArchivo = new JMenu("Archivo");
	static JMenu MenuEditar = new JMenu("Editar");
	static JMenu MenuAyuda = new JMenu("Ayuda");
	static JMenuItem guardar = new JMenuItem("Guardar");
	static JMenuItem cargar = new JMenuItem("Cargar");
	static JMenuItem nuevo = new JMenuItem("Nuevo");
	static JMenuItem cerrar = new JMenuItem("Cerrar");
	static JMenuItem color = new JMenuItem("Elegir Color");
	static JMenuItem limpiar = new JMenuItem("Limpiar");
	static JMenuItem controles = new JMenuItem("Controles");
	
	public static void Barra() 
	{
		cuadro.setJMenuBar(BarraMenu);
		BarraMenu.add(MenuArchivo);
		BarraMenu.add(MenuEditar);
		BarraMenu.add(MenuAyuda);
		MenuArchivo.setFont(fuente);
		MenuEditar.setFont(fuente);
		MenuAyuda.setFont(fuente);
		MenuArchivo.add(nuevo);
		MenuArchivo.add(cargar);
		MenuArchivo.add(guardar);
		MenuArchivo.add(cerrar);
		MenuEditar.add(color);
		MenuEditar.add(limpiar);
		MenuAyuda.add(controles);
		nuevo.setFont(fuente);
		cargar.setFont(fuente);
		guardar.setFont(fuente);
		cerrar.setFont(fuente);
		color.setFont(fuente);
		limpiar.setFont(fuente);
		controles.setFont(fuente);
		nuevo.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				Cargar.img2=null;
				Ventana.img=new BufferedImage(760,420,BufferedImage.TYPE_INT_ARGB);
				graph=img.createGraphics();
				graph.setColor(Color.white);
				graph.fillRect(0, 0, img.getWidth(), img.getHeight());
				panel.repaint();
			}
			
			
		});
		
		guardar.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				Guardar.Guarda();
			}
			
		});
		
		cargar.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				Cargar.Carga();
			}
			
		});
		
		cerrar.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
			
			
		});
		
		color.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				new EColor(Ventana.pincel);
			}
			
		});
		
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
		
		controles.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e) 
			{
				String control = "\r\n" + 
						"CONTROLES\r\n" + 
						"\r\n" + 
						"MOUSE\r\n" + 
						"\r\n" + 
						"Clic Derecho - Pintar\r\n" + 
						"Clic Izquierdo - Borrar\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"-----------------------------------------------------------------------------------------\r\n" + 
						"\r\n" + 
						"INTERFAZ\r\n" + 
						"\r\n" + 
						"Color del pincel - Elige el color con el que estas pintando\r\n" + 
						"Grosor del pincel - Elige el grosor del pincel\r\n" + 
						"Limpiar - Borra todos los trazos que has realizado\r\n" + 
						"	                 Si has cargado alguna imagen, esta no se borrará\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"-----------------------------------------------------------------------------------------\r\n" + 
						"\r\n" + 
						"BARRA DE MENU\r\n" + 
						"\r\n" + 
						"Archivo\r\n" + 
						"\r\n" + 
						"Nuevo - Crea una nueva imagen\r\n" + 
						"	               Si has cargado alguna imagen, esta se borrará\r\n" + 
						"Cargar - Carga una imagen en formato .jpg o .png\r\n" + 
						"Guardar - Guarda una imagen en formato .png\r\n" + 
						"Cerrar - Cierra el programa\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"Editar\r\n" + 
						"\r\n" + 
						"Elegir color - Elige el color con el que estas pintando\r\n" + 
						"Limpiar - Borra todos los trazos que has realizado\r\n" + 
						"	                 Si has cargado alguna imagen, esta no se borrará\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"Ayuda\r\n" + 
						"\r\n" +
						"Controles - Muestra una ventana con los controles del programa\n";
				
				
				JOptionPane.showMessageDialog(null, control);
			}
			
		});
	}
	
	public void actionPerformed(ActionEvent e) 
	{	
		
	}

}
