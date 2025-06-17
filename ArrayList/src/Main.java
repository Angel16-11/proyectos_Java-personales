//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {//Adding Exameple
    static Scanner leer=new Scanner(System.in);
    static ArrayList<String>names=new ArrayList<>();

    public static void main(String[] args) {
        names.add("Austin");
        names.add("Brian");
        names.add(1,"zeb");
        names.add(3,"olvia");
        names.add(2,"gwen");
        System.out.println(names);

        System.out.println();//changinExample

        names.set(0,"tony");
        names.set(2,"bruce");
        System.out.println(names);

        //removing elements
        System.out.println();
        names.remove(2);
        names.remove(3);
        System.out.println(names);

        //accesing elements
        //get(index)
        System.out.println();
        System.out.println(names.get(0));

        System.out.println();
        System.out.println("----------------Notes----------");
        ArrayList<Integer>myGrades=new ArrayList<Integer>();
        myGrades.add(80);//this uses autoboxixng
        myGrades.add(Integer.valueOf(90));//this doesn't use autoboxing
        myGrades.add(85);
        myGrades.add(76);
        System.out.println(myGrades);

        System.out.println();
        myGrades.add(1,93);
        myGrades.add(2,89);
        myGrades.add(2,myGrades.get(0));
        myGrades.set(4,97);

        System.out.println(myGrades.remove(2));
        System.out.println(myGrades.remove(4));

        myGrades.set(myGrades.size()-2,88);
        myGrades.add(myGrades.size(),70);
        myGrades.set(3,myGrades.get(0));

        System.out.println(myGrades);
    }
}