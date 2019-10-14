package robots;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
public class Robots {
    static DifferentialPilot pilot = new DifferentialPilot(5.6, 17.5f, Motor.A, Motor.B);
    static UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S2);
    static LightSensor light = new LightSensor(SensorPort.S1);
    public static void main(String[] args) {
        basic();
    }
    
    private static void basic() {
        System.out.println("hello world");
        Button.waitForAnyPress();
    }
}
