import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner leer=new Scanner(System.in);
    public static void main(String[] args) {

                                        //5 estudiantes con 5 clificaciones
        Estudiante[]curso =new Estudiante[5];
        curso[0]=new Estudiante("federico","brun",18);
        curso[1]=new Estudiante("Angel","Reyes",17);
        curso[2]=new Estudiante("josue","umanzor",22);
        curso[3]=new Estudiante("ruth ","ariana",18);
        curso[4]=new Estudiante("Camila","alessandra",18);

        System.out.println("cuantos estudiantes hay ene l curso:"+curso.length);
        System.out.println("como se llama el primer estudiante:"+curso[0].getName());
        for(int i=0;i<curso.length;i++){
            System.out.println("Ingrese las calificaciones de %s %s %s",curso[i].getName(),curso[i].getSurname());
            for(int j=0;i<curso[j].getScore().length;j++){
                System.out.println("nota de la materia 1:"+j+1);
                curso[i].getScore()[j]=leer.nextInt();
            }
        }

    }
    public void printArray(Estudiante[] cursoParam){
        for(Estudiante estudiante:cursoParam){
            System.out.printf("las notas de %s %s %s son:"estudiante.getName(),estudiante.getScore());
        }
    }


}