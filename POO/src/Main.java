//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona objPersona=new Persona();

        objPersona.creaPersona("marco","01-02-2001",17);

        System.out.println("-----persona creada------");
        System.out.println("nombre:"+objPersona.getNombre());
        System.out.println("Fecha de nacimiento:"+objPersona.getFechaNacimiento());
        System.out.println("Edad:"+objPersona.getEdad());

        objPersona.creaPersona("Ruby","01-16-2007",17);
        System.out.println("----------persona creada--------");
        System.out.println("nombre:"+objPersona.getNombre());
        System.out.println("Fecha de nacimiento:"+objPersona.getFechaNacimiento());
        System.out.println("Edad:"+objPersona.getEdad());
    }
}