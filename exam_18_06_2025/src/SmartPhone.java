public class SmartPhone extends Phone{
    private int batteryDuration;

    public int getBatteryDuration() {
        return batteryDuration;
    }

    public void setBatteryDuration(int batteryDuration) {
        if(batteryDuration<=0){
            throw new RuntimeException();
        }
        this.batteryDuration = batteryDuration;
    }

    @Override
    public String infoDevice() {
        return Integer.toString(this.batteryDuration);
        //sau return battery +"";
    }
}
