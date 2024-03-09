import java.util.ArrayList;
import java.util.List;

public class CarStock {

    public static void main(String[] args) {
        new Car("Tesla",100,125000);
        new Car("Lambo",150,230000);
        new Car("Toyota",120,160000);

        Stock.displayCars();
        for (Car car: Stock.getCarStock()){
            System.out.println(car.getModel());
            System.out.println(car.getTopSpeed());
            System.out.println(car.getPrice());
            if (car.getModel().equals("Tesla")){
                car.setPrice((int)(car.getPrice()*0.75));
                System.out.println(car.getPrice());
            }

        }

    }
}

class Stock{

    public static List<Car> getCarStock() {
        return carStock;
    }

    private static List<Car> carStock = new ArrayList<>();

    public static void displayCars(){
        for (Car car: carStock){
            System.out.println(car);
        }
    }
}

class Car{
    private final String model;
    private final int topSpeed;
    private int price;

    public Car(String model,int topSpeed,int price) {
        this.model = model;
        this.topSpeed = topSpeed;
        this.price = price;
        //make a stock if there is none and add the car to it, else - just add car
        if (Stock.getCarStock()==null){
            new Stock();
        }
        Stock.getCarStock().add(this);
    }

    public String getModel() {
        return model;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", topSpeed=" + topSpeed +
                ", price=" + price +
                '}';
    }
}
