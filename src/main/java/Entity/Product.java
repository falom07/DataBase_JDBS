package Entity;

import java.util.Objects;

public class Product {
    private int price;
    private String product;
    private String detail_information;
    public Product(){}

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

    public String getDetail_information() {
        return detail_information;
    }

    public void setDetail_information(String detail_information) {
        this.detail_information = detail_information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product1)) return false;
        return getPrice() == product1.getPrice() && Objects.equals(getProduct(), product1.getProduct()) && Objects.equals(getDetail_information(), product1.getDetail_information());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getProduct(), getDetail_information());
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", product='" + product + '\'' +
                ", detail_information='" + detail_information + '\'' +
                '}';
    }
}
