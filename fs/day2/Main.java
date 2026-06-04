abstract class SmartDevice{

    protected String deviceId;
    protected String deviceName;

    SmartDevice(String deviceId, String deviceName){
        this.deviceId=deviceId;
        this.deviceName=deviceName;
    }

    public abstract void runDiagnostic();
}

class SmartLight extends SmartDevice{
    SmartLight(String deviceId, String deviceName){
        super(deviceId, deviceName);
    }

    @Override
    public void runDiagnostic(){
        System.out.println(deviceName + " light diagnostic running");
    }


}

interface BatteryOperated{
    int getBatteryLevel();

    void triggerRechargeAlert() ;

}

class SmartCamera  extends SmartDevice implements BatteryOperated{

    int batteryLevel;


    SmartCamera(String deviceId, String deviceName, int batteryLevel) {
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }


    @Override
    public void runDiagnostic() {
        System.out.println(deviceName + " camera diagnostic running");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void triggerRechargeAlert() {
        System.out.println(deviceName + " camera battery low.");
    }


}

class SmartLock extends SmartDevice implements BatteryOperated {

    private int batteryLevel;

    SmartLock(String deviceId, String deviceName, int batteryLevel) {
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void runDiagnostic() {
        System.out.println(deviceName + " lock diagnostic running");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void triggerRechargeAlert() {
        System.out.println(deviceName + " lock battery low.");
    }
}




class HomeHub{
    public void executeNightlyRoutine(SmartDevice[] devices){
        for(SmartDevice device : devices){
            device.runDiagnostic();

            if( device instanceof BatteryOperated){
               
                BatteryOperated b = (BatteryOperated) device;

                int level = b.getBatteryLevel();

                if(level<20)
                    b.triggerRechargeAlert();

            }
        }
    }
}


public class Main {
    public static void main(String[] args) {

        SmartDevice[] devices = new SmartDevice[3];

        devices[0] = new SmartLight("L1", "Bedroom Light");
        devices[1] = new SmartCamera("C1", "Front Camera", 15);
        devices[2] = new SmartLock("S1", "Main Door Lock", 10);

        HomeHub hub = new HomeHub();

        hub.executeNightlyRoutine(devices);
    }
}