package main;

import classes.Student;
import classes.TuitionType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        float[] grades = {10, 7, 8};
        Student s2 = new Student("Ana", grades);
        grades[0] = 5;

        s1.setTuitionType(TuitionType.TAX);
        s1.setGrades(grades);
        grades[0] = 8;

        float[] marks=s2.getGrades();
        marks[0]=4;

        Student s3= (Student)s2.clone();
        System.out.println(s3.getName());
    }
}