
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class ModeloArrayList extends ModeloAbs
{
    protected ArrayList <Producto> lista;
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
    }

    // Implementar los metodos abstractos de ModeloAbs
    public boolean insertarProducto ( Producto p){
    	lista.add(p);
      return false;    
    }
 
    public boolean borrarProducto ( int codigo ){
      
    	for( Producto a : lista ) {
    		if(a.codigo==codigo) { //busco que el codigo coincida
    			lista.remove(a); // si el codigo coincide, lo borre
    			return true;
    		}
    	}
      return false;
    }
    
    public Producto buscarProducto ( int codigo) {
    	for( Producto a : lista ) {
    		if(a.codigo==codigo) {
    			return a;
    		}
    	}
        return null;
    }
    
    public void listarProductos (){
    	for( Producto a : lista ) {
    		System.out.println(a.toString());
    	}

    }
    
    public boolean modificarProducto (Producto nuevo){
    	
       return false;
    }
    
    public void serializacionOuyput() throws IOException {
    	try {
			FileOutputStream fichero = new FileOutputStream("C:/Users/Bryan/Desktop/fichero.dat");
			ObjectOutputStream exportar = new ObjectOutputStream (fichero);
			exportar.writeObject(lista);
			exportar.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void serializacionIn() throws IOException {
    	try {
			FileInputStream fichero = new FileInputStream("C:/Users/Bryan/Desktop/fichero.dat");
			ObjectInputStream leer = new ObjectInputStream (fichero);
			ArrayList <Producto> nuevoarray= (ArrayList<Producto>) leer.readObject();
			for(Producto e: nuevoarray) {
				System.out.println(e);
			}
			leer.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido leer el objeto");
		}
    }
    
}    
