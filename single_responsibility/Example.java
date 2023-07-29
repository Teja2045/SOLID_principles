package solid.single_responsibility;

// single responsibility, each class should only do one functionality
// like how the AreaCalculator only calculating area and the AreaPrinter is printing the area
class Square {
    long side;

    Square(long side) {
        this.side = side;
    }
}

class Rectangle {
    long length, breadth;

    Rectangle(long length, long breadth) {
        this.length = length;
        this.breadth = breadth;
    }
}

class AreaCalculator {
    static long area(Object shape) {
        // rect area
        if (shape instanceof Rectangle) {
            return ((Rectangle) shape).length * ((Rectangle) shape).breadth;
        }
        // square area
        long side = ((Square) shape).side;
        return side * side;
    }
}

class AreaPrinter {
    static void json(long area) {
        System.out.println("{\"area\":" + area + "}");
    }

    static void yaml(long area) {
        System.out.println("area=" + area);
    }
}

class Example {

    public static void main(String[] args) {
        Square sq = new Square(10L);
        long sqArea = AreaCalculator.area(sq);
        AreaPrinter.json(sqArea);
        AreaPrinter.yaml(sqArea);
    }
}
