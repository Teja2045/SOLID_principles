package solid.open_closed;

// classes should be closed for modification and open for extension

// wrong, because every time we need a new printer, we had to modify the class, that doesn't follow open/closed principle
/*
 class AreaPrinter {
    void jsonPrint(long area) {

    }
    void yamlPrint(long area) {

    }
    void csvPrint(long area) {

    }
    .....
 }
 */

// right way
interface AreaPrinter {
    void print(long area);
}
/*
class AreaPrinter {
    public void print(long area) {
      System.out.println(area);
    }
}

the other classes will extend this?
*/

class JsonAreaPrinter implements AreaPrinter {
    @Override
    public void print(long area) {
        System.out.println("\"area\"=" + area + "}");
    }
}

class YamlAreaPrinter implements AreaPrinter {
    @Override
    public void print(long area) {
        System.out.println("area=" + area);
    }
}

public class Example {

}
