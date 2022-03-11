package paquete;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Guardar{
	
	static JFileChooser guardar;
	static FileOutputStream salir;
	static File Archivo;
	static byte[] imagenguardada;
	static BufferedImage imgguardar = new BufferedImage(Ventana.img.getWidth(),Ventana.img.getHeight(), BufferedImage.TYPE_INT_ARGB);
	static Graphics graf2;

	
	public static String guardar(File Archivo, byte[] imagenguardada) 
	{
		String msj=null;
		try 
		{
			salir=new FileOutputStream(Archivo);
			salir.write(imagenguardada);
			msj="Se ha guardado el archivo";
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Hubo un error al guardar el archivo");
			e.printStackTrace();
		}
		return msj;
	}
	
	public static void Guarda()
	{
		
		try {
			guardar = new JFileChooser();
			guardar.showSaveDialog(guardar);
			Archivo = guardar.getSelectedFile();
			if ( Archivo == null )
			{
				return;
			}
			
			String Name = Archivo.getName();
			Name = Name + ".png";
			
			Archivo = new File(Archivo.getParent(),Name);
			
			
			imgguardar=new BufferedImage(Ventana.img.getWidth(), Ventana.img.getHeight(), BufferedImage.TYPE_INT_RGB);
			graf2=imgguardar.getGraphics();
			if(Cargar.img2!=null) 
			{
				graf2.drawImage(Cargar.image, 0,0,Ventana.panel);
			}
			graf2.drawImage(Ventana.img,0,0,Ventana.panel);


			ImageIO.write(imgguardar, "png", Archivo);
			JOptionPane.showMessageDialog(null, "Se ha guardado el archivo");
			} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Hubo un error al guardar el archivo");
			e.printStackTrace();
		}
			}
		
	}


