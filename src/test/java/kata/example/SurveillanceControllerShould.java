package kata.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static kata.example.SensorEvent.*;

public class SurveillanceControllerShould {
    Sensor sensor;
    Recorder recorder;
    SurveillanceController controller;

    @BeforeEach
    public void setup() {
        sensor = new MovementSensor();
        recorder = Mockito.mock(Recorder.class);
        controller = new SurveillanceController();
        controller.startSurveillance(
                sensor,
                recorder
        );
    }
    @Test
    public void stop_recording_when_not_movement_is_detected() {
        sensor.notifySuscriptors(MOVEMENT_NOT_DETECTED);

        Mockito.verify(recorder, Mockito.times(1)).stop();
    }

    @Test
    public void start_recording_when_movement_is_detected() {
        sensor.notifySuscriptors(MOVEMENT_DETECTED);

        Mockito.verify(recorder, Mockito.times(1)).start();
    }

    @Test
    public void stop_recording_when_there_unexpected_error_in_sensor() {
        sensor.notifySuscriptors(ERROR);

        Mockito.verify(recorder, Mockito.times(1)).stop();
    }
}
