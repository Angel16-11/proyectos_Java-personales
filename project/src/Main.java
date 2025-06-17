
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Main {
    static Scanner leer=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("***************************************************");
        System.out.println("1.Cifrado de mensajes");
        System.out.println("2.verfificacion de mensajeria");
        System.out.println("3.Original conteins");
        System.out.println("************************************************");
        System.out.print("que opcion desea hacer:");
        int opcion=leer.nextInt();
        while(opcion!=4){
            switch(opcion){
                case 1:
                    Cifrado();
                    break;
                case 2:
                    Mensajeria();
                    break;
                case 3:
                    Contains();
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;

            }//fin del swith
            System.out.print("ingrese opcion:");
            opcion=leer.nextInt();
        }

    }
    public static void Cifrado(){
        System.out.println("Ingrese su palabra:");
        String palabra=leer.next();
        palabra=palabra.toLowerCase();
        String palabra_c=" ";
        for(int i=0;i<palabra.length();i++){
            char pala=palabra.charAt(i);
            if(pala=='a'){
                pala='4';
            }else if(pala=='e'){
                pala='3';
            }else if(pala=='i'){
                pala='1';
            }else if(pala=='o'){
                pala='0';
            }else if(pala=='s'){
                pala='5';
            }else if(pala=='h'){
                pala='#';
            }else if(pala=='t'){
                pala='+';
            }
            palabra_c+=pala;
        }
        System.out.println("codigo sin cifrar:"+palabra);
        System.out.println("codigo cifrado:"+palabra_c);
    }

    public static void Mensajeria(){
        System.out.println("Mensaje que se ha enviado:");
        String palabra3 = leer.next();
        System.out.println("Mensaje recibido:");
        String palabra4 = leer.next();

        int sumaAscii1 = 0, sumaAscii2 = 0;

        // Calcular la suma ASCII de cada mensaje
        for (int i = 0; i < palabra3.length(); i++) {
            sumaAscii1 += palabra3.charAt(i);
        }

        for (int i = 0; i < palabra4.length(); i++) {
            sumaAscii2 += palabra4.charAt(i);
        }

        System.out.println("\nSuma total ASCII del mensaje 1: " + sumaAscii1);
        System.out.println("Suma total ASCII del mensaje 2: " + sumaAscii2);

        if (sumaAscii1 > sumaAscii2) {
            System.out.println("El mensaje 1 tiene mayor peso ASCII que el mensaje 2.");
        } else if (sumaAscii1 < sumaAscii2) {
            System.out.println("El mensaje 2 tiene mayor peso ASCII que el mensaje 1.");
        } else {
            System.out.println("Ambos mensajes tienen el mismo peso ASCII.");
        }
    }





    public static void Contains(){
        System.out.println("Ingrese la primera codena:");
        String idea=leer.next();
        System.out.println("Ingrese el texto que desea buscar:");
        String buscar=leer.next();
        int encontrar=0;
        int iguales=0;
        for(int i=0;i<=idea.length()-buscar.length();i++){
            iguales=0;
            for(int j=0;j<buscar.length();j++){
                if(idea.charAt(i+j)==buscar.charAt(j)){
                    iguales++;
                }

            }
            if(iguales==buscar.length()){
                encontrar++;
            }
        }
        if(encontrar>0){
            System.out.println("la palabra  "+buscar+" "+"si esta en "+idea);

        }else{
            System.out.println("La palabra "+buscar+" "+"no esta en "+idea);
        }

    }
}
