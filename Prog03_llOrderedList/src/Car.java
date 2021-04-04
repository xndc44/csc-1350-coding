
public class Car implements Comparable<Car> {
    private String make;
    private int year;
    private int price;


    public Car(String make, int year, int price) {
        this.make = make;
        this.year = year;
        this.price = price;
    }

 
    public String getMake() {
        return make;
    }

    
    public int getYear() {
        return year;
    }

    
    public int getPrice() {
        return price;
    }

   
    public int compareTo(Car other) {
        int makeComparison = this.make.compareTo(other.make);

        if (makeComparison != 0) {
            return makeComparison;
        }
        else {
            if (this.year != other.year) {
                return this.year - other.year;
            } else {
                return 0;
            }
        }
    }

   
    public String toString() {
        return String.format("Make: %s, Year: %s, Price: %s;", this.make, this.year, this.price);
    }
}
