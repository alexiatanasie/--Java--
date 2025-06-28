import java.io.Serializable;
import java.util.Objects;

public class Phone implements ElectronicDevices, Serializable, Cloneable {

    private float weight;
    private double diagonal;
    private String producer;

    public Phone() {
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if(weight>0){
            this.weight = weight;
        }
        else {
            throw  new IllegalArgumentException("must be > 0");
        }    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        if(diagonal>0){
            this.diagonal = diagonal;
        }
        else {
            throw  new IllegalArgumentException("must be > 0");
        }
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        if(producer!=null&producer.length()>1){
            this.producer = producer;
        }
        else{
            throw new IllegalArgumentException("producer must not be 0");
        }
    }

    @Override
    public String infoDevice() {
        return this.producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Float.compare(weight, phone.weight) == 0 && Double.compare(diagonal, phone.diagonal) == 0 && Objects.equals(producer, phone.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, diagonal, producer);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      Phone copy=(Phone) super.clone();
       copy.producer=this.producer;
       copy.weight=this.weight;
       copy.diagonal=this.diagonal;
       return copy;
    }
}
