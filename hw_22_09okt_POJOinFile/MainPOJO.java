package de.telran.hw_22_09okt_POJOinFile;

import java.io.*;

public class MainPOJO {
//  Реализуйте механизм сохранения и чтения объекта POJO Client в файл.
//Вот приблизительно наполнение класса Client.
//    private Long id;
//    private String status;
//    private Long taxCode;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String address;
//    private String phone;

    public static void main(String[] args) {
        Client cl1 = new Client(1000001L, "worker", 10000014L, "John", "Bern", "john@mail.post", "Berliner Str. 10", "+490657894516");
        Client cl2 = new Client(1010007L, "jobless", 5465455L, "Gary", "Gutter", "garry@mail.ru", "Dresdner Str. 48", "+498447852626");
        // запись объекта в файл
        try {
            FileOutputStream fos = new FileOutputStream(new File("D://POJO.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Запись объектов в файл
            oos.writeObject(cl1);
            oos.writeObject(cl2);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Чтение объектов из файла
        try {
            FileInputStream fis = new FileInputStream(new File("D://POJO.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Client o1 = (Client) ois.readObject();
            Client o2 = (Client) ois.readObject();
            System.out.println(o1.toString());
            System.out.println(o2.toString());
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
