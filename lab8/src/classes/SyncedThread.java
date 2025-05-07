package classes;


//un thread este o linie de executie separata.
//programul poate avea mai multe thread-uri care ruleaza in paralel
public class SyncedThread implements Runnable {
    private static int a=0;
    private static int b=0;
    private static Object lock=new Object(); //obiect pt blocarea accesului


    @Override
    public void run() {
        for(int i=0;i<5;i++){
            synchronized (lock){ //doar un singur thread poate intra in acel bloc la un moment dat
                System.out.println("a="+a+"b="+b);
                a++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b++;
            }
        }
    }
}
