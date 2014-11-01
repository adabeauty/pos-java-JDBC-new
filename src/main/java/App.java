import com.thoughtworks.iamcoach.pos.service.CartService;

public class App {

    public static void main(String[] args) {
        CartService cartService = new CartService();

        Printer printer = new Printer(cartService);
        System.out.println(printer.printList());
    }
}
