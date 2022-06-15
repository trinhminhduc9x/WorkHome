package Ss6_inheritance.practice;



class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square("xanh", true, 5.0);
        System.out.println(square);
    }
}