import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("que opcion desea hacer:");
        int opcion=leer.nextInt();
        if(opcion==1){
            System.out.print("escriba el valor que quiere que llegue a 100:");
            int numero=leer.nextInt();
            for(int i=numero; i<=100 ;i++){
                System.out.print(i+",");

            }//fin del for

        }else if(opcion==2){
            int i=1;
            while(i<10){
                System.out.print(i+",");
                i+=1;
            }

        }



    }//fin del public
}//fin del main