//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    double monto;//monto depositado al fin de cada año
    double principal=1000.0;//monto inicial antes de los intereses
    double tasa = 0.05;//tasa de interes

        //encabezados
        System.out.printf("%s20s%n","Anio","%s20s%n","monto en deposito");

        //calcular el monto eb deposito para los diez años
        for(int anio=1;anio<=10;++anio){
            //calcular el nuevo monto para el año especificado
            monto=principal*Math.pow(1.0+tasa,anio);
            //muestra el año y el monto en deposito
            System.out.printf("%4d%10.2f%n",anio,monto);
        }
    }
}//fin de la clase