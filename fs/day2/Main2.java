abstract class DeliveryDrone{
    String droneId;

    public DeliveryDrone(String droneId) {
        this.droneId=droneId;
    }

    

    public abstract void deliverPackage();
}

interface Airborne {

    void flyToDestination();

    default void requestAirTrafficClearance() {
        System.out.println("Clearance");
    }
}

interface GroundBased{
    void navigateSidewalks();
}

class Quadcopter extends DeliveryDrone implements Airborne {

    public Quadcopter(String droneId) {
        super(droneId);
    }

    @Override
    public void deliverPackage() {
        System.out.println("Quadcopter delivering package");
    }

    @Override
    public void flyToDestination() {
        System.out.println("Quadcopter jandiya ae");
    }
}
class CityRover extends DeliveryDrone implements GroundBased {

    public CityRover(String droneId) {
        super(droneId);
    }

    @Override
    public void deliverPackage() {
        System.out.println("CityRover delivering package");
    }

    @Override
    public void navigateSidewalks() {
        System.out.println("CityRover navigating sidewalks");
    }
}
class HybridVTOL extends DeliveryDrone implements Airborne, GroundBased {

    public HybridVTOL(String droneId) {
        super(droneId);
    }

    @Override
    public void deliverPackage() {
        System.out.println("HybridVTOL delivering package");
    }

    @Override
    public void flyToDestination() {
        System.out.println("HybridVTOL flying");
    }

    @Override
    public void navigateSidewalks() {
        System.out.println("HybridVTOL navigating ground");
    }
}

public class Main2 {
    public static void main(String[] args) {

        DeliveryDrone d1 = new Quadcopter("D1");
        DeliveryDrone d2 = new CityRover("D2");
        DeliveryDrone d3 = new HybridVTOL("D3");

        d1.deliverPackage();
        d2.deliverPackage();
        d3.deliverPackage();

        Airborne a = (Airborne) d1;
        a.flyToDestination();
        a.requestAirTrafficClearance();
    }
}
