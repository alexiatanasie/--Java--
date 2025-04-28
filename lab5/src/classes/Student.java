package classes;

import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

public class Student implements Comparable<Student> {
    private String name;
    private float grades;

    public Student() {
    }

    public Student(String name, float grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrades() {
        return grades;
    }

    public void setGrades(float grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", grades=").append(grades);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Float.compare(grades, student.grades) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grades);
    }

    @Override
    public int compareTo(Student o) {
        if (o == null) {
            return -1;
        }
        if (Float.compare(grades, o.grades) == 0) {
            if (name == o.name) {
                return 0;
            } else if (name != null) {
                return name.compareTo(o.name);
            } else return 1;
        } else return Float.compare(grades, o.grades);
    }
}
