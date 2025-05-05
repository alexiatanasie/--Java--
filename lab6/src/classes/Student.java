package classes;


import java.io.*;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID=4756748L; //cand o vers a cls e diferita de o vers a cls scrisa intr-iun fisier
    private String name;
    private int age;
    private float grade;

    public Student() {
    }

    public Student(String name, int age, float grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    //fct de serializare
   public void serialize(){
       // FileOutputStream fileOutputStream=null;
      //  ObjectOutputStream objectOutputStream=null;
       try {
           FileOutputStream fileOutputStream=new FileOutputStream("object.bin");
           ObjectOutputStream objectOutputStream=new ObjectOutputStream((fileOutputStream));
           objectOutputStream.writeObject(this);
           objectOutputStream.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
//        finally {
//           //punem finally cand nu am return. daca am finally si return, finally se executa inainte de return
//           if(objectOS!=null){
//               obj.close() il mut aici si dupa vine un try catch
//           }
//       }
   }
   public static Student deserialize(){
       try {
           FileInputStream fileInputStream=new FileInputStream("object.bin");
           ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
           Student s=(Student)objectInputStream.readObject();
           objectInputStream.close();
           return s;
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }return null;
   }

}
