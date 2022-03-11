package paquete;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Cargar {
	
	static JFileChooser abrir = new JFileChooser();
	static File abrirarchivo;
	static byte[] imagen;
	static FileInputStream entrar;
	static Image image;
	static BufferedImage img2;

	
	public static byte[] Abrir(File archivo) 
	{
		byte[] imagen = new byte[1024*100];
		try 
		{
			entrar= new FileInputStream(archivo);
			entrar.read(imagen);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Hubo un error al leer el archivo");
			e.printStackTrace();
		}
		return imagen;
	}
	
	
	public static void Carga() 
	{
		if (abrir.showDialog(null,null)==JFileChooser.APPROVE_OPTION) 
		{
			abrirarchivo=abrir.getSelectedFile();
			if(abrirarchivo.canRead()) 
			{
				if(abrirarchivo.getName().endsWith("jpg") || abrirarchivo.getName().endsWith("JPG") || abrirarchivo.getName().endsWith("png") 
						|| abrirarchivo.getName().endsWith("PNG")) 
				{
					imagen=Abrir(abrirarchivo);
					try {
						img2 = new BufferedImage(Ventana.img.getWidth(), Ventana.img.getHeight(), BufferedImage.TYPE_INT_ARGB);
						img2= ImageIO.read(abrirarchivo);
					} catch (Exception e) {
						
						JOptionPane.showMessageDialog(null, "Hubo un error al leer el archivo");
						e.printStackTrace();
					}
					image = img2.getScaledInstance(Ventana.img.getWidth(), Ventana.img.getHeight(), Image.SCALE_DEFAULT);
					Ventana.img=new BufferedImage(760,420,BufferedImage.TYPE_INT_ARGB);

				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Archivo No Compatible");
				}
			}
		}
	}
	

}
