package kata.example;

public class SurveillanceController implements Suscriptor{
    private Recorder recorder;

    public void startSurveillance(Sensor sensor, Recorder recorder) {
        this.recorder = recorder;
        sensor.subscribe(this);
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (event == SensorEvent.MOVEMENT_DETECTED)
            this.recorder.start();
        else if (event == SensorEvent.MOVEMENT_NOT_DETECTED || event == SensorEvent.ERROR){
            this.recorder.stop();
        }
    }
}
