package Entity;

import java.util.Objects;

public class Order {
    private int id_user;
    private int price;
    private String product;

    public Order() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId_user() == order.getId_user() && getPrice() == order.getPrice() && Objects.equals(getProduct(), order.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_user(), getPrice(), getProduct());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_user=" + id_user +
                ", price=" + price +
                ", product='" + product + '\'' +
                '}';
    }
}
