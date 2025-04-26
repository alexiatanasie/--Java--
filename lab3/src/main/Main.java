package main;

import classes.Car;
import classes.Vehicle;
import interfaces.Taxable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[][]matrix=new int[3][2];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.println( matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        float[][]raggedArray=new float[2][1];
        raggedArray[0]=new  float[1];
        raggedArray[1]=new float[3];
        for(int i=0;i<raggedArray.length;i++){
            for(int j=0;j<raggedArray[i].length;j++){
                System.out.println( raggedArray[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(float f:raggedArray[1]){
            System.out.println(f);
        }

        Vehicle v=new Car();
        v.move();
        Car c=new Car("Renault",25000,"yellow");
        System.out.println(c.ComputeTax());
        Taxable t=c;
        System.out.println(t.ComputeTax());

        if (c instanceof Cloneable){
            Car c2=(Car)c.clone();
            System.out.println(c2.getColor());
        }

    }
}