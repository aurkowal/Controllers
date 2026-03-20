package pl.coderslab.controller.day4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;
import pl.coderslab.model.ProductDao;

import java.util.List;
import java.util.Random;

@Controller
public class CartController {

    private Cart cart;

    private ProductDao productDao;

    @Autowired
    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

//	@RequestMapping("/addtocart")
//	@ResponseBody
//	public String addtocart() {
//		Random rand = new Random();
//		cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
//		return "addtocart";
//	}

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart(@RequestParam long id, @RequestParam int quantity) {
        List<Product> products = productDao.getList();
        Product product = null;
        for (Product candidate : products) {
            if (candidate.getId() == id) {
                product = candidate;
                break;
            }
        }
        cart.addToCart(new CartItem(quantity, product));
        return "addtocart";
    }

    @RequestMapping(path = "/cart", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String cart() {
        StringBuilder result = new StringBuilder();
        List<CartItem> items = cart.getCartItems();
        int quantity = 0;
        double price = 0;
        for (CartItem item : items) {
            quantity += item.getQuantity();
            price += item.getQuantity() * item.getProduct().getPrice();
            result.append(item.getProduct().getId()).append(" / ").append(item.getProduct().getName()).append(" / ")
                    .append(item.getProduct().getPrice()).append(" / ").append(item.getQuantity()).append("<br />");
        }
        result.append("W koszyku jest ").append(items.size()).append(" pozycji.").append("<br />")
                .append("W koszyku jest ").append(quantity).append(" produktów.").append("<br />")
                .append("Wartość koszyka to ").append(price);
        return result.toString();
    }
}