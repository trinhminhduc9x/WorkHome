package Ss5.baitap;

public class Circle {
    private  double radius =1.0;
    private String color="red";
    public Circle(){}
    public Circle(double radius, String color){
        this.radius=radius;
        this.color =color;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return Math.PI*Math.pow(this.radius,2.0);
    }
   void display(){
       System.out.println(" radius is : " +getRadius() +" \n Area is :"+ getArea() +"\n color "+ this.color );
   }
}
