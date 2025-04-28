package main;

import classes.Student;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        Student s1=new Student("corbul",10);
        System.out.println(s1);
        Student s2=new Student("corbul",10);
        Student s3=new Student("dima",9.9f);

        Set<Student>set=new TreeSet<>();

        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println();
        for(Student s:set){
            System.out.println(s);
        }

        //HASHSET NU PASTREAZA ORDINEA
        set=new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println();
        for(Student s:set){
            System.out.println(s);
        }
        //DACA VREAU ORDINE CRESCATOARE :
        Set<Student>hashSet=new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        //copiem intr-o lista
        List<Student>list=new ArrayList<>(hashSet);
        //sort cresc
        Collections.sort(list);
        //print
        for(Student s:list){
            System.out.println(s);
        }
        Map<Integer,Student>map=new TreeMap<>();
        map.put(2,s1);
        map.put(3,s2);
        map.put(6,s3);

        System.out.println(map.get(6));
        for(int key:map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
        Map<String,Student>hashMap=new HashMap<>();
        hashMap.put(s1.getName(),s1);
        hashMap.put(s3.getName(),s3);
        System.out.println(hashMap.get("dima"));
    }
}