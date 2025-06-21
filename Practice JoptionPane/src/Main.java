//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        char respuesta = 's';
        while (respuesta == 's' || respuesta == 'S') {
            int opcion = menu();

            switch (opcion) {
                case 0: // Saludo y suma
                    String nombre = JOptionPane.showInputDialog("Hola, por favor escriba su nombre:");
                    JOptionPane.showMessageDialog(null, "Hola " + nombre + ", bienvenido al programa de Java.");
                    int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Por favor, ingrese el primer número:"));
                    int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Por favor, ingrese el segundo número:"));
                    int suma = numero1 + numero2;
                    int numero3=Integer.parseInt(JOptionPane.showInputDialog("escriba su primer numero a restar:"));
                    int numero4=Integer.parseInt(JOptionPane.showInputDialog("Escriba su segundo numero a restar:"));
                    int resta=numero3-numero4;
                    JOptionPane.showMessageDialog(null,"su resta final es:"+resta);
                    JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + suma);
                    break;

                case 1: // Área del triángulo
                    int base = Integer.parseInt(JOptionPane.showInputDialog("Escriba la base del triángulo:"));
                    int altura = Integer.parseInt(JOptionPane.showInputDialog("Escriba la altura del triángulo:"));
                    int area = base * altura / 2;
                    JOptionPane.showMessageDialog(null, "El área del triángulo es: " + area);
                    break;
                case 2:
                    int edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
                    if(edad>=18){
                        JOptionPane.showMessageDialog(null,"Usted es capaz de votar!!");
                    }else{
                        JOptionPane.showMessageDialog(null,"Usted no es capaz de votar lo sentimos!!");
                    }
                    break;
                case 3:
                    int numerop=Integer.parseInt(JOptionPane.showInputDialog("escriba su numero:"));
                    if(numerop%2==0){
                        JOptionPane.showMessageDialog(null,"su numero es par");
                    }else{
                        JOptionPane.showMessageDialog(null,"su numero no es par");
                    }
                    break;
                case 4:
                    int peso=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su peso"));
                    int estatura=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su estatura:"));
                    int IMC=peso/estatura*estatura;
                    if(IMC<18.5){
                        JOptionPane.showMessageDialog(null,"usted tiene un bajo peso felicidades");
                    }else if(IMC<=18.5&&IMC<=24.9){
                        JOptionPane.showMessageDialog(null,"usted tiene un peso normal");
                    }else if(IMC<=25 && IMC<=29.9){
                        JOptionPane.showMessageDialog(null,"LO sentimos usted tiene sobrepeso");
                    }else if(IMC>=30){
                        JOptionPane.showMessageDialog(null,"usted tiene obesidad");
                    }
                    break;
                case 5://tabla de multiplicar
                    int numero=Integer.parseInt(JOptionPane.showInputDialog("Escriba su numero"));
                    int limite=Integer.parseInt(JOptionPane.showInputDialog("Escriba el limite de la tabla"));
                    int acumulador=0;
                    String tabla="";
                    for(int i=1;i<=limite;i++){
                        acumulador=numero*i;
                        JOptionPane.showMessageDialog(null,numero+"x"+i+"="+acumulador+"\n");
                    }

                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Esto es información", "Info", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Esto es una advertencia", "Cuidado", JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Esto es un error", "Error", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "¿Estás seguro?", "Pregunta", JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Sin ícono", "Plano", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 7:
                    int n1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su primer numero:"));
                    int n2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su segudno numero:"));
                    int n3=Integer.parseInt(JOptionPane.showInputDialog("Igrese su tercer numero:"));
                    int mayor = 0;
                    if(n1>n2 && n1>n3){
                        mayor=n1;
                    }else if(n2>n1 && n2>n3){
                        mayor=n2;
                    }else if(n3>n1 && n3>n2){
                        mayor=n3;
                    }
                    JOptionPane.showMessageDialog(null,"el numero mayor es "+mayor);
                    break;
                case JOptionPane.CLOSED_OPTION: // Cerrar o cancelar menú
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta o cancelada. El programa finalizará.");
                    respuesta = 'n';
                    continue;
            }

            String continuar = JOptionPane.showInputDialog("¿Desea continuar? (s/n):");
            if (continuar != null && !continuar.isEmpty()) {
                respuesta = continuar.charAt(0);
            } else {
                respuesta = 'n';
            }
        }
    }

    public static int menu() {
        String[] opciones = {"Saludo y suma", "Área de un triángulo","Edad y permiso","Numero par o impar","calculadora de Imc"
        ,"Tabla de multiplicar","cambio de iconos","numero mayor"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        return seleccion; // 0, 1 o JOptionPane.CLOSED_OPTION (-1)
    }
}
