package classes;

//fara sincronizare
//problema: doua thread uri acceseaza var a si b fara protectie, asta poate duce la valori afisate incorect sau intercalate
public class UnsyncedThread extends Thread {
    private static int a=0;
    private static int b=0;

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("a="+a+"b="+b);
            a++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        b++;
    }
}
