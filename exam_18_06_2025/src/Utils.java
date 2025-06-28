import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;


public class Utils {
    private static List<ElectronicDevices>list;

    public static List<ElectronicDevices> createPhones(int n) throws Exception{

        if(n<=0) throw new Exception();
        list=new ArrayList<ElectronicDevices>();
        for(int i=0;i<n;i++){
            list.add(new Phone());
        }
        return list;
    }
    //txt file
    public static List<ElectronicDevices> readPhones(String file) throws IOException {
        List<ElectronicDevices> phones=new ArrayList<ElectronicDevices>();
        RandomAccessFile raf=new RandomAccessFile(file,"r");
        String line;
        Phone temp=null;

        while ((line = raf.readLine()) != null) {
            temp=new Phone();
            phones.add(temp);
            temp.setWeight(Float.parseFloat(line));

            line=raf.readLine();
            temp.setDiagonal(Double.parseDouble(line));

            line= raf.readLine();
            temp.setProducer(line);
        }
        raf.close();
        return phones;
    }

    //deserializare
    public static void writeBinaryPhones(String file, List<ElectronicDevices> listP) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(listP);
        oos.close();
    }

    //serializare
    public static List<ElectronicDevices> readBinaryPhones(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        List<ElectronicDevices>devices=(List<ElectronicDevices>) ois.readObject();
        ois.close();
        return devices;
    }

    //serializare in txt
    public static void writePhones(String file, List<ElectronicDevices> listP) throws IOException {
        RandomAccessFile raf=new RandomAccessFile(file,"rw");

        raf.setLength(0);

        for(ElectronicDevices d: listP){
            if(d instanceof Phone){
                Phone phone=(Phone)d;

                raf.writeBytes(Float.toString(phone.getWeight()));
                raf.writeBytes(Double.toString(phone.getDiagonal()));
                raf.writeBytes(phone.getProducer());
            }
        }
        raf.close();
    }
}
