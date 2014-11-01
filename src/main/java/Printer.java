import com.thoughtworks.iamcoach.pos.Dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.Dao.CategoryImple;
import com.thoughtworks.iamcoach.pos.module.CartItem;
import com.thoughtworks.iamcoach.pos.module.Category;
import com.thoughtworks.iamcoach.pos.service.CartService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Printer {
    CartService cartService = new CartService();
    ArrayList<CartItem> cartItems = cartService.getCartInfo();

    public String printList() {
        return printShopName() + "\n"
                + printDate() + "\n"
                + printAllCartItems() + "\n"
                + printTotal();
    }

    private String printShopName() {
        return "        ********Let's Go 购物清单*********" + "\n"
                + "----------------------------------------------------------";
    }

    private String printDate(){
        Date dateAndTime = new Date();

        java.text.DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(dateAndTime);
        String time = String.format("%tr", dateAndTime);

        return "          " + date + "    " + time;
    }

    private String printAllCartItems(){
        String allCartItems = "************************************************" + "\n";
        CategoryDao categoryImple = new CategoryImple();

        ArrayList<Category> categories = categoryImple.getCategories();
        for(int i=0; i<categories.size(); i++){
            int id = Integer.parseInt(categories.get(i).getId());

            if(divideCartItems(id).size() != 0){
                allCartItems += printCategory(divideCartItems(id));
            }
        }
        allCartItems +="************************************************";
        return allCartItems;
    }

    private String printCategory(ArrayList<CartItem> cartItems){
        String categoryText = "";

        CategoryDao categoryImple = new CategoryImple();
        categoryText += categoryImple.getCategoryById(cartItems.get(0).getCategoryId()).getName() + "\n";

        for (CartItem cartItem : cartItems) {
            categoryText += "名称：" + cartItem.getName() + "   数量：" + cartItem.getNum()
                    + "   单价：" + cartItem.getPrice() + "元" + "   单位：" + cartItem.getUnit()
                    + "   小计：" + cartItem.getSubtotal() + "元" +"\n";

        }
        return categoryText + "\n";
    }

    private String printTotal(){

        return  "优惠前：" + cartService.getTotalSum() + "元"
                + "   优惠金额：" + (cartService.getTotalSum() - cartService.getActualSum()) + "元"
                + "   总计：" + cartService.getActualSum()+ "元" + "\n"
                + "----------------------------------------------------------";
    }


    private ArrayList<CartItem> divideCartItems(int categoryId) {
        ArrayList<CartItem> dividedCartItems = new ArrayList<CartItem>();

        for(int j=0; j<cartItems.size(); j++){
            if(cartItems.get(j).getCategoryId() == categoryId){
                dividedCartItems.add(cartItems.get(j));
            }
        }
        return dividedCartItems;
    }
}
