public class Conserve extends Product {
    private Material material;

    public Conserve(String name, double price, int shelf_Life, Material material) {
        super(name, price, shelf_Life);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "\n" + super.toString() + " Conserve [material=" + material + "]";
    }

    @Override
    public String toCsv() {
        return this.getClass().getName() + "," + getName() + "," + getPrice() + "," + getShelf_Life() + "," + getMaterial();
    }
}
