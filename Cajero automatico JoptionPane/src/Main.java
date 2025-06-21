import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int saldo = 1000;
        char respuesta = 's';

        while (respuesta == 's' || respuesta == 'S') {
            int opcion = menu();

            switch (opcion) {
                case 0: // Consultar saldo
                    JOptionPane.showMessageDialog(null, "Su saldo actual es: L. " + saldo);
                    break;

                case 1: // Retirar
                    int retirar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
                    if (retirar <= saldo) {
                        saldo -= retirar;
                        JOptionPane.showMessageDialog(null, "Retiro exitoso. Nuevo saldo: L. " + saldo);
                    } else {
                        JOptionPane.showMessageDialog(null, "no tiene dinero parce ");
                    }
                    break;

                case 2: // Depositar
                    int depositar = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto desea depositar?"));
                    saldo += depositar;
                    JOptionPane.showMessageDialog(null, "Depósito exitoso. Nuevo saldo: L. " + saldo);
                    break;
                case 3: // Validar contraseña fuerte
                    String contraseña = JOptionPane.showInputDialog("Ingrese una contraseña:");

                    boolean tieneMayus = false;
                    boolean tieneMinus = false;
                    boolean tieneNumero = false;

                    if (contraseña.length() >= 8) {
                        for (int i = 0; i < contraseña.length(); i++) {
                            char c = contraseña.charAt(i);
                            if (Character.isUpperCase(c)) {
                                tieneMayus = true;
                            } else if (Character.isLowerCase(c)) {
                                tieneMinus = true;
                            } else if (Character.isDigit(c)) {
                                tieneNumero = true;
                            }
                        }
                    }

                    if (contraseña.length() >= 8 && tieneMayus && tieneMinus && tieneNumero) {
                        JOptionPane.showMessageDialog(null, "Contraseña válida y fuerte ");
                    } else {
                        JOptionPane.showMessageDialog(null, " Contraseña débil. Debe tener:\n- Mínimo 8 caracteres\n- Una mayúscula\n- Una minúscula\n- Un número");
                    }
                    break;
                case 4:
                    String nombre;
                    String edadText;
                    int edad=-1;
                    String[]paises={"Honduras","El salvador","Guatemala","Nicaragua","costa rica"};
                    String pais;
                    do{
                        nombre=JOptionPane.showInputDialog("Ingrese su nombre:");
                        if(nombre==null || nombre.isEmpty()){
                            JOptionPane.showMessageDialog(null,"El nombre no puede estar vacio!!");
                        }
                    }while(nombre==null && nombre.isEmpty());
                    boolean edadValida=false;
                    do{
                        edadText=JOptionPane.showInputDialog("Ingrese su edad");
                        try{
                            edad=Integer.parseInt(edadText);
                            edadValida=true;
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,"debe ungresar numeros para la edad:");
                        }
                    }while(!edadValida);
                    // Elegir país con combo
                    pais = (String) JOptionPane.showInputDialog(
                            null,
                            "Seleccione su país:",
                            "País",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            paises,
                            paises[0]
                    );
                    // Mostrar todos los datos juntos
                    String mensaje = "Datos ingresados:\n"
                            + "Nombre: " + nombre + "\n"
                            + "Edad: " + edad + "\n"
                            + "País: " + pais;

                    JOptionPane.showMessageDialog(null, mensaje, "Resumen de datos", JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 5: // Encuesta de sistema operativo
                    String[] opciones = {"Windows", "Mac", "Linux", "Otro"};
                    int votosWindows = 0;
                    int votosMac = 0;
                    int votosLinux = 0;
                    int votosOtro = 0;

                    for (int i = 1; i <= 5; i++) {
                        int respuestas= JOptionPane.showOptionDialog(
                                null,
                                "¿Qué sistema operativo prefieres?\n(Encuestado #" + i + ")",
                                "Encuesta",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opciones,
                                opciones[0]
                        );

                        switch (respuestas) {
                            case 0: votosWindows++; break;
                            case 1: votosMac++; break;
                            case 2: votosLinux++; break;
                            case 3: votosOtro++; break;
                            default: break; // Si cierra la ventana
                        }
                    }

                    String resultado = "Resultados de la encuesta:\n"
                            + "Windows: " + votosWindows + " votos\n"
                            + "Mac: " + votosMac + " votos\n"
                            + "Linux: " + votosLinux + " votos\n"
                            + "Otro: " + votosOtro + " votos";

                    JOptionPane.showMessageDialog(null, resultado, "Resultados", JOptionPane.INFORMATION_MESSAGE);
                    break;




                case JOptionPane.CLOSED_OPTION:
                default:
                    JOptionPane.showMessageDialog(null, "Opción cancelada o incorrecta. Finalizando...");
                    respuesta = 'n';
                    continue;
            }

            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                respuesta = 's';
            } else {
                respuesta = 'n';
            }

        }
    }

    public static int menu() {
        String[] opciones = {"Consultar saldo", "Retirar", "Depositar","contraseña debil o fuerte ","nombre,edad,pais","sistema operativo preferido "};
        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
    }
}

