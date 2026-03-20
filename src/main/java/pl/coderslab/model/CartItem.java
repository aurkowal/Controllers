package pl.coderslab.model;


public class CartItem {
    private int quantity;
    private Product product;

    public CartItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CartItem{");
        sb.append("quantity=").append(quantity);
        sb.append(", product=").append(product);
        sb.append('}');
        return sb.toString();
    }
}