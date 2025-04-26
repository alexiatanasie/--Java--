//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1=null;
        Student s2=new Student();
        System.out.println(s2.getName());

        Student s3=new Student("Ana",9.9f);
        Student s4=s3.myClone();
        s4.setName("Ama");
        System.out.println(s4.getName());
    }
}