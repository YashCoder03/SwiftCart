package com.order.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.order.order.client.CartClient;
import com.order.order.client.InventoryClient;
import com.order.order.dto.CartItem;
import com.order.order.dto.OrderDTO;
import com.order.order.dto.OrderItemDTO;
import com.order.order.entity.OrderEntity;
import com.order.order.entity.OrderItemEntity;
import com.order.order.entity.OrderStatus;
import com.order.order.repository.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final CartClient cartClient;
    private final InventoryClient inventoryClient;

    @Transactional
    public OrderDTO  createOrder(String userId){

        List<CartItem> cart = cartClient.getCart(userId);

        if(cart.isEmpty()){
            throw new RuntimeException("Cart is Empty");
        }
        
        OrderEntity order = new OrderEntity();
        order.setUserId(UUID.fromString(userId));
        order.setOrderStatus(OrderStatus.CREATED);

        List<OrderItemEntity> orderItems = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;

        for(CartItem item : cart) {
            
            String productId = String.valueOf(item.getProductId()); 
            Integer quantity = item.getQuantity();
            System.out.println("ProductId"+item.toString());
            Boolean inStock = inventoryClient.checkStock(productId);
            if(!inStock) {
                throw new RuntimeException("Not in stock");

            }
            inventoryClient.reducesStock(productId,quantity);

            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setProductId(UUID.fromString(productId));
            orderItem.setQuantity(quantity);
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }

        order.setItem(orderItems);
        order.setTotalAmount(totalAmount);

        OrderEntity saved = orderRepository.save(order);
        cartClient.deleteCart(userId);

        return convertToDTO(saved);

    } 
    public void deleteAllOrder(){
        orderRepository.deleteAll();

    }

    public List<OrderDTO> getAllOrders(UUID userId) { 
        List<OrderEntity> orders = orderRepository.findByUserId(userId); 
        return  orders
                        .stream() 
                        .map(this::convertToDTO) 
                        .collect(Collectors.toList()); 
    }

    private OrderDTO convertToDTO(OrderEntity order) { 
        OrderDTO dto = new OrderDTO(); 
        dto.setId(order.getId()); 
        dto.setUserId(order.getUserId()); 
        dto.setTotalAmount(order.getTotalAmount()); 
        dto.setOrderStatus(order.getOrderStatus().name()); 
        dto.setItems( order.getItem()
                                    .stream() 
                                    .map(this::convertItemToDTO) 
                                    .collect(Collectors.toList())); 
        return dto; 
    } 
        
    private OrderItemDTO convertItemToDTO(OrderItemEntity item) { 
        OrderItemDTO dto = new OrderItemDTO(); 
        dto.setId(item.getId()); 
        dto.setPrice(item.getPrice()); 
        return dto;
     }

}
