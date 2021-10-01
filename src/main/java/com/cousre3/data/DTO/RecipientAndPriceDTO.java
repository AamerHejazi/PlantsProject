package com.cousre3.data.DTO;

import java.math.BigDecimal;

public class RecipientAndPriceDTO {
    private String recipientName;
    private BigDecimal price;

    //You'll probably need a constructor like this so CriteriaBuilder can create
    public RecipientAndPriceDTO(String recipientName, BigDecimal price) {
        this.recipientName = recipientName;
        this.price = price;
    }
    /* getters and setters */

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}