import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import com.thoughtworks.iamcoach.pos.dao.ItemImple;
import com.thoughtworks.iamcoach.pos.service.CartService;
import com.thoughtworks.iamcoach.pos.util.ReadFileUlti;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        ArrayList<String> inputs = ReadFileUlti.readFile("cart.txt");
        ItemDao itemImpl = new ItemImple();
        CartService cartService = new CartService(inputs, itemImpl);

        Printer printer = new Printer(cartService);
        System.out.println(printer.printList());
    }
}
