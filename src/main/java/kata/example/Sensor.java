package kata.example;

public interface Sensor {
     void notifySuscriptors(SensorEvent sensorEvent) ;
     void subscribe(Suscriptor controller);
}
