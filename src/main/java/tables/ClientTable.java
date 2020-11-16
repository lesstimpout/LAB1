package tables;

import entities.Client;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class ClientTable implements Serializable {
    private List<Client> clients;

    public ClientTable() {
        clients = new ArrayList<>();
        clients.add(new Client(1, "Светлана", "Цмугун", 10));
        clients.add(new Client(2, "Иван", "Лабенко", 9));
        clients.add(new Client(3, "Петр", "Митрофанов", 8));
        clients.add(new Client(4, "Максим", "Конотоп", 7));
        clients.add(new Client(5, "Дмитрий", "Цуканов", 6));
        clients.add(new Client(6, "Елена", "Бойко", 5));
        clients.add(new Client(7, "Максим", "Крам", 4));
        clients.add(new Client(8, "Екатерина", "Чихун", 3));
        clients.add(new Client(9, "Инна", "Шушпанова", 2));
        clients.add(new Client(10, "Владислав", "Боровик", 1));
    }

    public List<Client> getClients() {
        return clients;
    }
}
