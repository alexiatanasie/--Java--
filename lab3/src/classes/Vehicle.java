package classes;

public abstract class Vehicle implements Cloneable {
    private String producer;
    private double price;

    public Vehicle(){
    }

    public Vehicle(String producer, double price) {
        this.producer = producer;
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Vehicle copy=(Vehicle)super.clone();
        copy.producer=this.producer;
        copy.price=this.price;
        return copy;
    }
    public abstract void move();
}
