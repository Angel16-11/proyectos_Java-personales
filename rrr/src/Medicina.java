


/**
 *
 * @author angel
 */
public class Medicina {//me decia que no podia cambiarlo por que era private asi que lo puse public are
    public String nombre;
    public int codigo;
    public  int existencias;
    public int precio;
    public String presentacion;

    public Medicina(String nombre, int codigo, int existencia, String presentacion){

    }

    public Medicina(String nombre,int c,int e,int p,String pr){
        this.nombre=nombre;
        this.codigo=c;
        this.existencias=e;
        this.precio=p;
        this.presentacion=pr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    @Override
    public String toString(){
        return "nombre:"+this.nombre+"|"+"codigo:"+this.codigo+"|"+"existencia:"+this.existencias+"|"+"precio:"+this.precio+"|"+"presentacion:"+this.presentacion ;
    }


}
