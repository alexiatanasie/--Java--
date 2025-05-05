package main;

import classes.Student;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scanner=new Scanner(System.in);
       // String name="";
        System.out.print("name:");
        String name=scanner.nextLine();

       // int age=0;
        System.out.print("age:");
        int age=scanner.nextInt();

        System.out.println("grade=");
        float grade=scanner.nextFloat();

        Student student1 =new Student(name,age,grade);
        System.out.println(student1);
        scanner.close();

        Student student=new Student("Alex",21,10);// si se afis astea daca nu pun ce am sus
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("student.txt");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            BufferedWriter writer=new BufferedWriter(outputStreamWriter);
            writer.write(student.getName());
            writer.newLine();
            writer.write(Integer.toString(student.getAge()));
            writer.newLine();
            writer.write(Float.toString(student.getGrade()));
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileInputStream fileInputStream=new FileInputStream("student.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String n=reader.readLine();
            int a=Integer.parseInt(reader.readLine());
            float g=Float.parseFloat(reader.readLine());

            Student stud2=new Student(n,a,g);
            System.out.println(stud2);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileOutputStream fileOutputStreambin=new FileOutputStream("student.bin");
            DataOutputStream dataOutputStream=new DataOutputStream(fileOutputStreambin);
            dataOutputStream.writeUTF(student.getName());
            dataOutputStream.writeInt(student.getAge());
            dataOutputStream.writeFloat(student.getGrade());
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream=new FileInputStream("student.bin");
            DataInputStream dataInputStream=new DataInputStream(fileInputStream);
            String name1=dataInputStream.readUTF();
            int age1=dataInputStream.readInt();
            float grade1=dataInputStream.readFloat();
            dataInputStream.close();

            Student student3=new Student(name1,age1,grade1);
            System.out.println(student3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        student.serialize();
        Student stud3=Student.deserialize();
        System.out.println(stud3);

        //DAT
        FileOutputStream outputStream=new FileOutputStream("Student.dat");
        ObjectOutputStream oos=new ObjectOutputStream(outputStream);
        oos.writeObject(student1);

        FileInputStream fis=new FileInputStream("Student.dat");
        ObjectInputStream objectInputStream=new ObjectInputStream(fis);
        Student stud5=(Student) objectInputStream.readObject();
        System.out.println(stud5);
    }

    //serializarea intregii clase
    //tb acea cls sa fie marcata ca serializable=>Student implements Serializable
    //cand am serializable in cls Student am un warning si o sa fie serialVersionUID
    //serializarea cica e contagioasa :)))) haha ce glm pe prof



}