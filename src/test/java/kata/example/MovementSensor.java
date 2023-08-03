package kata.example;

import java.util.ArrayList;
import java.util.List;

public class MovementSensor implements Sensor {
    List<Suscriptor> suscriptors;

    public MovementSensor() {
        suscriptors = new ArrayList<>();
    }

    @Override
    public void notifySuscriptors(SensorEvent sensorEvent) {
        this.suscriptors.forEach(suscriptor -> suscriptor.processEvent(sensorEvent));
    }

    @Override
    public void subscribe(Suscriptor controller) {
        suscriptors.add(controller);
    }
}
