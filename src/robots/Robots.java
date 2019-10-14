package robots;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
public class Robots {
    static DifferentialPilot pilot = new DifferentialPilot(5.6, 17.5f, Motor.A, Motor.B);
    static UltrasonicSensor ultra = new UltrasonicSensor(SensorPort.S2);
    static LightSensor light = new LightSensor(SensorPort.S1);
    public static void main(String[] args) {
        simple();
        followLine();
    }
    
    private static void simple() {
        System.out.println("hello world");
        Button.waitForAnyPress();
    }
    
    private static int readLightValue(String location) {
        System.out.println("press to read " + location);
        Button.waitForAnyPress();
        int light = light.readValue();
        System.out.println("light value of " + location + ": " + light);
        Button.waitForAnyPress();
        return light;
    }
    
    private static void followLine() {
        int floorValue = readLightValue("floor");
        int tapeValue = readLightValue("tape");
        System.out.println("Tracking line until infinity");
        while(true) {
            int currentValue = light.readValue();
            if (onTape(currentValue, floorValue, tapeValue)) {
                pilot.steer(30);
                waitComplete();
            }
            else {
                pilot.steer(-30);
                waitComplete();
            }
        }
    }
    
    private static boolean onTape(int value, int floor, int tape) {
        return Math.abs(floor - value) > Math.abs(tape - value);
    }
}
