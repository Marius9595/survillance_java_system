package kata.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static kata.example.SensorEvent.*;

public class SurveillanceControllerShould {
    @Test
    public void stop_recording_when_not_movement_is_detected() {
        Sensor sensor = new MovementSensor();
        Recorder recorder = Mockito.mock(Recorder.class);
        SurveillanceController controller = new SurveillanceController();
        controller.startSurveillance(
                sensor,
                recorder
        );

        sensor.notifySuscriptors(MOVEMENT_NOT_DETECTED);

        Mockito.verify(recorder, Mockito.times(1)).stop();
    }

    @Test
    public void start_recording_when_movement_is_detected() {
        Sensor sensor = new MovementSensor();
        Recorder recorder = Mockito.mock(Recorder.class);
        SurveillanceController controller = new SurveillanceController();
        controller.startSurveillance(
                sensor,
                recorder
        );

        sensor.notifySuscriptors(MOVEMENT_DETECTED);

        Mockito.verify(recorder, Mockito.times(1)).start();
    }

    @Test
    public void stop_recording_when_there_unexpected_error_in_sensor() {
        Sensor sensor = new MovementSensor();
        Recorder recorder = Mockito.mock(Recorder.class);
        SurveillanceController controller = new SurveillanceController();
        controller.startSurveillance(
                sensor,
                recorder
        );

        sensor.notifySuscriptors(ERROR);

        Mockito.verify(recorder, Mockito.times(1)).stop();
    }
}
