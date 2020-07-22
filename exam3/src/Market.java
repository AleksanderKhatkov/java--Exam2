import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market {
    private List<Product> list = new ArrayList<>();

    // 5)   Добавление продукта
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public String toString() {
        return "Market [list=" + list + "]";
    }

    // 6)   Удаление продукта по названию и цене
    public void remove(String name, double price) {
        list.removeIf((Product product)-> (product.getName().equals(name)||(product.getPrice()==(price))));
    }


    // 7)   Вывод всех продуктов на экран по возрастанию цены !!!
    public void print() {
        list.sort((Product product1, Product product2)-> (((Double)product1.getPrice()).compareTo((Double)product2.getPrice())));
        System.out.println(this);
    }


    //  8)	Выбор продуктов по заданному диапазону цены;
    public List<Product> findByPrice(double minPrice, double maxPrice) {
        List<Product> result = new ArrayList<>(list);
        result.removeIf((Product product) -> (product.getPrice() < minPrice || product.getPrice() > maxPrice));
        return result;
    }

   //  9)	Подсчет продуктов заданного срока годности;
   public int countByProduct(int shelf_Life) {
       int count = 0;
       for (Product product : list) {
           if (product.getShelf_Life()==shelf_Life) {
               ++count;
           }
       }
       return count;
   }

    // 10)	Сохранения в текстовый файл в заданным именем;
    public void writeToCsvFile(String outputFileName)
            throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(outputFileName);
        for (Product product : list) {
            pw.println(product.toCsv());
        }
        pw.close();
    }

    // 11)	Загрузка из текстового файла;
    public void readFromCsvFile(String inputFileName) throws FileNotFoundException, MyException {
        Scanner sc = new Scanner(new File(inputFileName));
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] fields = line.split(",");

            switch (fields[0]) {
                case "MilkProduct":
                    list.add(new MilkProduct(fields[1], Double.valueOf(fields[2]),
                            Integer.valueOf(fields[3]), Integer.valueOf(fields[4])));
                    break;
                case "Conserve":
                    list.add(new Conserve(fields[1], Double.valueOf(fields[2]),
                            Integer.valueOf(fields[3]), Material.valueOf(fields[4])));
                    break;
                default:
                    throw new MyException("Error in Class Name");
            }
        }
        sc.close();
    }
}
