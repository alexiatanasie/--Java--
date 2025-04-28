package main;
import classes.Student;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Student s1=new Student("Alexia",10);
        Student s2=new Student("Alex",7);
        System.out.println(s1);
        System.out.println(eq("abc","abc"));

        List<Integer>list=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        List<Student> studentList=new Vector<>();
        studentList.add(s1);
        studentList.add(s2);
        for(Student s:studentList){
            s=new Student("lo",0);
            System.out.println(s);
        }
        for(Iterator<Student> it=studentList.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        for(int i=0;i<studentList.size();i++){
            System.out.println(studentList.get(i));
        }
        int x=5;
        int y=3;
        interchange(x,y);
        System.out.println(x + " " + y);
        Int a=new Int();
        a.value=5;
        Int b=new Int();
        b.value=8;
        interchange(a,b);
        System.out.println(a.value+" "+b.value);
    }
    public static <T>boolean eq(T val1, T val2){
        return val1.equals(val2);
    }
    static class Int{
        public int value;
    }
    public static void interchange(Int x, Int y) {
        Int aux = x;
        x = y;
        y = aux;
    }

    public static void interchange(int x, int y) {
        int aux = x;
        x = y;
        y = aux;

    }

}