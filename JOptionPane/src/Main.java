//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
    String cadena;
    int entero;
    char letra;
    double decimal;
    String nombre = JOptionPane.showInputDialog(null, "¿Cómo te llamas?");
    int opcion = JOptionPane.showConfirmDialog(null,
            "Hola, " + nombre + ". ¿Quieres continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
    if (opcion == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null, "¡Genial, seguimos!");
    } else {
        JOptionPane.showMessageDialog(null, "¡nos vemos pronto!");
    }



        cadena=JOptionPane.showInputDialog("escriba una cadena(letras)");
    entero=Integer.parseInt(JOptionPane.showInputDialog("Digita un numero entero:"));
    letra=JOptionPane.showInputDialog("Digite un caracter").charAt(0);
    decimal=Double.parseDouble(JOptionPane.showInputDialog("ingrese su cadena:"));

    JOptionPane.showMessageDialog(null,"la cadena es:"+cadena);
        JOptionPane.showMessageDialog(null,"el numero entero es:"+entero);
        JOptionPane.showMessageDialog(null,"el caracter es:"+letra);
        JOptionPane.showMessageDialog(null,"su decimal es:"+decimal);

    }
}