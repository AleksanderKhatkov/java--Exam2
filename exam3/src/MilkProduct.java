public class MilkProduct extends Product {

    private int fat_Сontent;

    public MilkProduct(String name, double price, int shelf_Life, int fat_Сontent) {
        super(name, price, shelf_Life);
        this.fat_Сontent = fat_Сontent;
    }

    public int getFat_Сontent() {
        return fat_Сontent;
    }

    public void setFat_Сontent(int fat_Сontent) {
        this.fat_Сontent = fat_Сontent;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() + " MilkProduct [fat_Сontent=" + fat_Сontent + "]";
    }

    @Override
    public String toCsv() {
        return this.getClass().getName() + "," + getName() + "," + getPrice() + "," + getShelf_Life() + "," + getFat_Сontent();
    }
}