package nycgarage;

import java.time.LocalDateTime;

/**
 *
 * @author harry
 */
public class Car implements Comparable<Car> {
    private String plateNum;
    private LocalDateTime startingDurationH;
    private int expectedDuration;
    
    Car(int expectedDuration, String platenum, LocalDateTime startingDurationH){
        super();
        this.plateNum = platenum;
        this.expectedDuration = expectedDuration;
        this.startingDurationH = startingDurationH;
    }
    
    void setplateNum(String n){
        this.plateNum = n;
    }

    void setStartingDurationH(LocalDateTime n){
        this.startingDurationH = n;
    }

    void setexpectedDuration(int n){
        this.expectedDuration = n;
    }
    
    public String getPlate(){
        return plateNum;
    }
    
    public int getexpectedDuartion(){
        return expectedDuration;
    }
    
    LocalDateTime getStartDurationH(){
        return startingDurationH;
    }
    
    @Override
    public String toString(){
        return plateNum + " " + expectedDuration;
    }

    @Override
    public int compareTo(Car otherCar) {
        // Compare cars based on expected duration
        return Integer.compare(this.expectedDuration, otherCar.expectedDuration);
    }
}
