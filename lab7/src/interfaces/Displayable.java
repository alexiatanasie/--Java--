package interfaces;

public interface Displayable {
    void display();
    default void displayHello(){
        System.out.println("hello");
    }
}
