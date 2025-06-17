public class Empleado {

    static String Company="My Company LTD";

    private String name;
    private int dni;
    private int age;

    public Empleado(){

    }

    public Empleado(String nameParam,int dniParam,int ageParam){
        this.name=nameParam;
        this.dni=dniParam;
        this.age=ageParam;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void iamWorking(){
        System.out.println("Estoy trabajando");
    }
}
