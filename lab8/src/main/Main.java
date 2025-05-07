package main;

import classes.SyncedThread;
import classes.UnsyncedThread;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        UnsyncedThread t1=new UnsyncedThread();
//        t1.start();
//        UnsyncedThread t2=new UnsyncedThread();
//        t2.start();
        SyncedThread t3=new SyncedThread();
        new Thread(t3).start(); //porneste un nou thread care ruleaza run()
        SyncedThread t4=new SyncedThread();
        new Thread(t4).start();

        new Thread(()->{ //thread cu lambda. creez pe loc un thread fara cls separata( de ex nu as mai face cls synced thread)
            System.out.println("message from another thread");
        }).start();
        System.out.println("message from main thread");

        List<Integer>list=List.of(1,2,3,4,5,6,7,8,9);
        int sum=list.parallelStream().reduce((x,y)->x+y).get();
        System.out.println(sum);

        //reduce combina toate valorile intr-un singur rezultat
        //daca lista e goala get() va da eroare
        //parallelstream se fol py mai multe thread uri simultan
    }
}