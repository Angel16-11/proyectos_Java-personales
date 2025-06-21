public class Empleado {
    private String nombre;
    private String cargo;
    private char sexo;
    private int salario;

    public Empleado(){

    }

    public Empleado(String nombre,String cargo,char sexo,int salario){
        this.nombre=nombre;
        this.cargo=cargo;
        this.sexo=sexo;
        this.salario=salario;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo=cargo;
    }

    public char getSexo(){
        return sexo;
    }
    public void setSexo(char sexo){
        this.sexo=sexo;
    }

    public int getSalario(){
        return salario;
    }
    public void setSalario(int salario){
        this.salario=salario;
    }

    @Override
    public String toString(){
        return "nombre:"+nombre+
                "|cargo:"+cargo+
                "|sexo:"+sexo+
                "|salario"+salario;
    }
}
