public class Product {
    private String id;
    private String name;

    Product(String newId, String newName) {
        id = newId;
        name = newName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
