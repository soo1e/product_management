package kr.co.soo1e.product.management.presentation;

public class ProductDTO {
    private long id;
    private String name;
    private Integer price;
    private Integer amount;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(long id) {
        this.id = id;
    }
}
