package Entity;

import java.util.Objects;

public class ChoppingCart {
    private int id_buyer;
    private int id_product;

    public ChoppingCart() {
    }

    public int getId_buyer() {
        return id_buyer;
    }

    public void setId_buyer(int id_buyer) {
        this.id_buyer = id_buyer;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoppingCart that)) return false;
        return getId_buyer() == that.getId_buyer() && getId_product() == that.getId_product();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_buyer(), getId_product());
    }

    @Override
    public String toString() {
        return "ChoppingCart{" +
                "id_buyer=" + id_buyer +
                ", id_product=" + id_product +
                '}';
    }
}
