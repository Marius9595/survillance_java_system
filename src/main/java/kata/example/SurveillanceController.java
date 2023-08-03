package kata.example;

public class SurveillanceController implements Suscriptor{
    private Sensor sensor;
    private Recorder recorder;

    public void startSurveillance(Sensor sensor, Recorder recorder) {
        this.sensor = sensor;
        this.recorder = recorder;
        this.sensor.subscribe(this);
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (event == SensorEvent.MOVEMENT_DETECTED)
            this.recorder.start();
        else if (event == SensorEvent.MOVEMENT_NOT_DETECTED){
            this.recorder.stop();
        }
    }
}
