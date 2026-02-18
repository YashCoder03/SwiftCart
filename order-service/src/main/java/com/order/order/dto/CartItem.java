package com.order.order.dto;


import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID productId;
    private Integer quantity;
    
}
