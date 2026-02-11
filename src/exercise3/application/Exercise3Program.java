package exercise3.application;

import exercise3.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Exercise3Program {
    public static void main(String[] Args){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER CLIENTE DATA: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDateString = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateString);

        Client client = new Client(name, email, birthDate);

        System.out.println("ENTER ORDER DATA: ");
        System.out.print("Status (PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED): ");
        String statusString = sc.nextLine().toUpperCase();
        OrderStatus status = OrderStatus.valueOf(statusString);

        System.out.println("How many items to this order? ");
        int itemsQuantity = sc.nextInt();

        LocalDateTime moment = LocalDateTime.now();

        Order order = new Order(moment, status, client);

        for(int i = 1; i <= itemsQuantity; i++){
            sc.nextLine();
            System.out.printf("ENTER #%d ITEM DATA: \n", i);

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(product, productQuantity, productPrice);
            order.addOrderItem(orderItem);
        }




        sc.close();
    }
}
