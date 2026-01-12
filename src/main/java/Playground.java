public class Playground {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(5, 5);

        Point result = p1.plus(p2);
        System.out.println(result.getX()); // 15
        System.out.println(result.getY()); // 25
    }
}



