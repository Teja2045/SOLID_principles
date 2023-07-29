package solid.dependency_inversion;

// classes should depend on abstractions, not concretions

// wrong
// here class Square has a dependency on jsonPrinter, that shouldn't be the case
/* 
class JsonAreaPrinter {
    public void print(long area) {
        System.out.println("\"area\"=" + area + "}");
    }
}

class Square {
    long side;
    JsonAreaPrinter jsonp = new JsonAreaPrinter();

    Square(long side) {
        this.side = side;
    }

    long area() {
        return side * side;
    }

    void printArea() {
        jsonp.print(side);
    }
}
*/

// rather than that concrete dependency, the dependency should be abstract

interface IAreaPrinter {
    void print(long area);
}

class JsonAreaPrinter implements IAreaPrinter {
    @Override
    public void print(long area) {
        System.out.println("\"area\"=" + area + "}");
    }
}

class YamlAreaPrinter implements IAreaPrinter {
    @Override
    public void print(long area) {
        System.out.println("area=" + area);
    }
}

class Square {
    IAreaPrinter printer;
    long side;

    Square(IAreaPrinter printer, long side) {
        this.printer = printer;
        this.side = side;
    }

    long area() {
        return side * side;
    }

    void printArea() {
        printer.print(side);
    }
}

public class Example {
    public static void main(String[] args) {
        Square square = new Square(new YamlAreaPrinter(), 10);
        square.printArea();
    }
}
