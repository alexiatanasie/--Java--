import java.io.IOException;
import java.util.List;

public class VectorThread implements Runnable{

    public List<ElectronicDevices> phoneList;
    public double avgWeight;

    public VectorThread(String file) throws IOException, ClassNotFoundException {
        phoneList=Utils.readBinaryPhones(file);
    }

    public List<ElectronicDevices> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<ElectronicDevices> phoneList) {
        this.phoneList = phoneList;
    }

    public double getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(double avgWeight) {
        this.avgWeight = avgWeight;
    }

    @Override
    public void run() {
        int sum=0;
        for(int i=0;i<phoneList.size();i++){
            sum+=((Phone)phoneList.get(i)).getWeight();

        }
        avgWeight=sum/phoneList.size();
    }
}
