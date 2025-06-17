//entrada basica a un cuadro de dialogo
import javax.swing.JOptionPane;

public class DialogoNombre{

    public static void main(String []args){
        //pida al usuario que escriba su nombre
        String nombre=JOptionPane.showInputDialog("cual es su nombre?");
        //crea el mensaje
        String mensaje=
                String.format("Bienvenido,%s,a la programacion en java!",nombre);
        //muestra el mensaje para darle la bievenida al usuario
        JOptionPane.showMessageDialog(null,mensaje);
    }//fin del main
}//fin del class