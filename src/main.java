import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {

    public static void main(String[] args) throws Exception {
        ProductsImpl Store = new ProductsImpl();
        int a;
        Scanner in;

        do {
            in = new Scanner(System.in);
            System.out.print("\033[H\033[2J");
            System.out.println("Print: ");
            System.out.println("    1 to add product ");
            System.out.println("    2 to delete a product ");
            System.out.println("    3 to find product by id ");
            System.out.println("    4 to find product's by name ");
            System.out.println("    5 to add starting products to database (for codeReview)");
            System.out.println("    0 to exit: ");
            System.out.print("Input : ");
            a = in.nextInt();
            int timeout = 2;
            switch (a) {
                case 0:
                    break;

                case 1:
                    Product newProd = enterProd();
                    if (Store.addProduct(newProd)) {
                        System.out.println("User Added");
                    } else {
                        System.out.println("Id is already Used");
                    }
                    TimeUnit.SECONDS.sleep(timeout);
                    break;
                case 2:
                    Product oldProd = enterProd();
                    String msg = (Store.deleteProduct(oldProd) == true) ? "User Deleted"
                            : "Cannot find Product with this Id";
                    System.out.println(msg);
                    TimeUnit.SECONDS.sleep(timeout);
                    break;
                case 3:
                    System.out.println("I found only this -> " + Store.getName(enterId()));
                    TimeUnit.SECONDS.sleep(timeout);
                    break;
                case 4:
                    System.out.println("I found only this -> " + Store.findByName(enterName()).toString());
                    TimeUnit.SECONDS.sleep(timeout);
                    break;
                case 5:
                    Store.addMoreProducts();
                    System.out.println("Done");
                    TimeUnit.SECONDS.sleep(timeout);
                    break;
                default:
                    System.out.println("I do not understand that");
                    TimeUnit.SECONDS.sleep(timeout);
                    break;
            }
        } while (a != 0);
        in.close();
    }

    public static Product enterProd() {
        Scanner in = new Scanner(System.in);
        String id, name;

        System.out.println("");
        System.out.print("enter Id: ");
        id = in.next();
        System.out.print("enter Name: ");
        name = in.next();
        Product newProd = new Product(id, name);
        return newProd;
    }

    public static String enterId() {
        Scanner in = new Scanner(System.in);
        String id;
        System.out.println("");
        System.out.print("enter id: ");
        id = in.next();
        return id;
    }

    public static String enterName() {
        Scanner in = new Scanner(System.in);
        String name;
        System.out.println("");
        System.out.print("enter name: ");
        name = in.next();
        return name;
    }

}
