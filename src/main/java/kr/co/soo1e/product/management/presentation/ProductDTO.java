package kr.co.soo1e.product.management.presentation;

import jakarta.validation.constraints.NotNull;

public class ProductDTO {
    private long id;
    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
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
