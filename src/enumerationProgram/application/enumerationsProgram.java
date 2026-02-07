package enumerationProgram.application;

import enumerationProgram.entities.Order;
import enumerationProgram.enums.OrderStatus;

import java.util.Date;

public class enumerationsProgram {
    public static void main(String[] Args){

        Order order = new Order(115, new Date(), OrderStatus.DELIVERED);

        System.out.println(order);

        OrderStatus os1 = OrderStatus.DELIVERED; // Direct OrderStatus into a variable OrderStatus
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED"); // Receiving a String to OrderStatus

        System.out.println(os1);
        System.out.println(os2);


    }
}
