package solid.liskov_substitution;

// wrong

// sub class shouldn't narrow down the parent's features
// or
// sub class should be substitutable with parent class
interface Shape {
    long area();
}

class Pain implements Shape {

    public long area() {
        throw new IllegalStateException("Pain doesn't have shape");
    }

}

class Example {
    public static void main(String[] args) {
        Shape pain = new Pain();
        pain.area();
    }
}
