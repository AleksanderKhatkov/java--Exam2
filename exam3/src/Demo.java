import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Market market = new Market();


        // создать текстовый файл с 6-8 продуктами, имя: in.txt. Загрузить из текстового
        try {
            market.readFromCsvFile("in.txt");
            market.print();
        } catch (FileNotFoundException | MyException e) {
            System.out.println(e);
        }


        // добавить 2 товара
        market.add(new MilkProduct("Сыр", 12.5, 21, 45));
        market.add(new Conserve("Зеленый горошек", 2.12, 120, Material.GLASS));

/*
        // удалить один товар (название и цена – ввести с консоли)
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название товара: ");
        String name = in.nextLine();
        System.out.println("Введите цену товара: ");
        double cost = in.nextDouble();

        market.remove(name, cost);
        in.close();
*/


        /*
        market.add(new MilkProduct("Творог", 5.35, 5, 9));
        market.add(new MilkProduct("Творог", 4.70, 3, 1));
        market.add(new MilkProduct("Кефир", 1.9, 12, 3));
        market.add(new MilkProduct("Йогурт", 1.25, 15, 5));
        market.add(new Conserve("Джем", 3.48, 180, Material.GLASS));
        market.add(new Conserve("Огурцы", 3.15, 360, Material.GLASS));
        market.add(new Conserve("Сельдь", 3.12, 360, Material.METAL));
        System.out.println("1=" + market);
        System.out.println("______________________________________________________________________________");
*/



        market.remove("Творог",5.35);
        System.out.println("2=" + market);
        System.out.println("______________________________________________________________________________");

        market.add(new MilkProduct("Творог", 5.35, 5, 9));

        System.out.println("3=" + market);
        System.out.println("______________________________________________________________________________");
        market.print();

        System.out.println("______________________________________________________________________________");
        List<Product> listByPrice = market.findByPrice(1.5 , 5.0);
        System.out.println("listByPrice = " + listByPrice);
        System.out.println("______________________________________________________________________________");
        System.out.println("count of shelf_Life  = " + market.countByProduct(5));
        System.out.println("______________________________________________________________________________");

        //вызываем метод для записи в файл
        try {
           market.writeToCsvFile("in.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            market.writeToCsvFile("out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //вызываем метод для читения из файла
        try {
            market.readFromCsvFile("out.txt");
            market.print();
        } catch (FileNotFoundException | MyException e) {
            System.out.println(e);
        }

    }
}
