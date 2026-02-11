package exercise3.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItem = new ArrayList<>();


    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItem;
    }

    public void addOrderItem(OrderItem newOrderItem) {
        if(newOrderItem == null){
            throw new IllegalArgumentException("Order item must not be null.");
        };
        orderItem.add(newOrderItem);
    }

    public void removeOrderItem(OrderItem newOrderItem) {
        orderItem.remove(newOrderItem);
    }

    public Double total(){
        Double total = 0.0;
        for(OrderItem oi : orderItem){
            total += oi.subTotal();
        }
        return total;
    }
}
