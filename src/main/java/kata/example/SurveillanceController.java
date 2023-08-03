package kata.example;

public class SurveillanceController implements Suscriptor{
    private Recorder recorder;

    public void startSurveillance(Sensor sensor, Recorder recorder) {
        this.recorder = recorder;
        sensor.subscribe(this);
    }

    @Override
    public void processEvent(SensorEvent event) {
        if (isNeededToBeRecorded(event))
            this.recorder.start();
        else if (isNotNeededToBeRecorded(event)){
            this.recorder.stop();
        }
    }

    private static boolean isNeededToBeRecorded(SensorEvent event) {
        return event == SensorEvent.MOVEMENT_DETECTED;
    }

    private static boolean isNotNeededToBeRecorded(SensorEvent event) {
        return event == SensorEvent.MOVEMENT_NOT_DETECTED || event == SensorEvent.ERROR;
    }
}
