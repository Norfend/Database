package CP5;

import CP5.model.entities.Order;
import CP5.services.ClientServices;
import CP5.services.ManyToManySELECT;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger rootLogger = Logger.getLogger("");
        //rootLogger.setLevel(Level.OFF);
/*        ClientServices.addClient("John", "Doe", "JohnDoe",
                "JohnDoeJohnDoe");
        ClientServices.readClient("John", "Doe");*/
        ClientServices.updateClient("John", "New Phone Number");
        ClientServices.readClient("John", "Doe");
/*        ClientServices.deleteClient("John");
        ClientServices.readClient("John", "Doe");*/
        List<Order> orders = ManyToManySELECT.select("Misha");
        for (var order: orders) {
            System.out.println(order.getPayer().getId().toString() + " " + order.getSubject().toString());
        }
    }
}
