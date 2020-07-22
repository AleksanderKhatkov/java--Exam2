/*1) Определить абстрактный класс Продукт с информацией о названии, цене (плавающая точка), сроке годности (целое число=количество дней);
2) Определить класс-наследник МолочныйПродукт с дополнительной информацией о жирности (число);	MilkProduct
3) Определить класс-наследник Консервы с дополнительной информацией о материале тары (перечисление: GLASS, METAL); 	Conserve
4) Определить класс-коллекцию Магазин для объектов Продукт, который предоставляет следующие возможности (методы):
5)	Добавление продукта;
6)	Удаление продукта по названию и цене;
7)	Вывод всех продуктов на экран по возрастанию цены;
8)	Выбор продуктов по заданному диапазону цены;
9)	Подсчет продуктов заданного срока годности;
10)	Сохранения в текстовый файл в заданным именем;
11)	Загрузка из текстового файла;
12) При реализации генерировать и обрабатывать исключительные ситуации, в том числе своих классов.
*/
public abstract class Product {
    private String name;
    private double price;
    private int shelf_Life;


    public Product(String name, double price, int shelf_Life) {
        this.name = name;
        this.price = price;
        this.shelf_Life = shelf_Life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShelf_Life() {
        return shelf_Life;
    }

    public void setShelf_Life(int shelf_Life) {
        this.shelf_Life = shelf_Life;
    }

    @Override
    public String toString() {
        return "Product [name='" + name + '\'' + ", price=" + price + ", shelf_Life=" + shelf_Life + "]";
    }
    public abstract String toCsv();
}
