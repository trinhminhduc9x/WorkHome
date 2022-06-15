package Ss4.bai1;

public class Fan {
    public static void main(String[] args) {
        Fan fan1= new Fan();
    }
    final int SLOW = 1;
    final int MEDIUM = 1;
    final int FAST = 1;
    private int speed = SLOW;
    private boolean on = false;
    private double radius =5;
    private String color = "Blue";

    public Fan() {
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String toString (){
        if (this.isOn()){
            return "Fan is on,speed " + this.getSpeed() + ", color : " + this.getColor()+", radius" + this.getRadius();
        }else {
            return "Fan is off,color: " + this.getColor()+ ", radius " + this.getRadius();
        }
    }
}
