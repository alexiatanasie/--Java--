package classes;

import interfaces.Taxable;

public class Car extends Vehicle implements Taxable {
    private String color;
    private Engine engine;
    private final int NB_OF_DOORS;

    //ctr cu atributele din Vehicle + color de aici
    public Car(){
        this("",0,"white");

    }

    public Car(String producer, double price, String color) {
        super(producer, price);
        this.color = color;
        NB_OF_DOORS=4;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void move() {
        System.out.println("the car is moving");
    }

    @Override
    public double ComputeTax() {
        return super.getPrice()*0.05;
    }

    class Engine{
        public int power;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car copy=(Car)super.clone();
        copy.color=this.color;
        if(this.engine!=null){
            copy.engine=new Engine();
            copy.engine.power=this.engine.power;
        }
        return copy;

    }
}
