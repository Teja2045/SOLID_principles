package solid.Interface_segregation;

// an interface should't force a class to implement a method that it can't
// long interfaces should break down into smaller ones

// wrong
/* here circle doesn't have a volume, why should it be forced to implement something it doesn't have?

interface Shape {
    long area();
    long volume();
}

class Square implements Shape {

    long side;
    Square(long side) {
        this.side = side;
    }

    @Override
    public long area() {
        return side * side;
    }

    @Override
    public long volume() {
        throw new UnsupportedOperationException("circle can't implement method 'volume'");
    }
}
*/

// correct

interface Shape {
    long area();
}

interface Shape3D extends Shape {
    long volume();
}

class Square implements Shape {
    long side;

    Square(long side) {
        this.side = side;
    }

    public long area() {
        return side * side;
    }
}

class Cube implements Shape3D {
    long side;

    Cube(long side) {
        this.side = side;
    }

    public long area() {
        return side * side;
    }

    public long volume() {
        return side * side * side;
    }
}

public class Example {
    public static void main(String[] args) {
        Square sq = new Square(10);
        System.out.println(sq.area());

        Cube cb = new Cube(10);
        System.out.println(cb.area());
    }
}
