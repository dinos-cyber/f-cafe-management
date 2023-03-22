package Data;

/**
 *
 * @author NaNiDekka
 */
public class DoBan {
    private String name;
    private int price;
    private int stock;

    public DoBan() {
    }

    public DoBan(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void showInfo(){
        System.out.printf("|%-15s|%-15d|%-10d|\n", this.name, this.price, this.stock);
    }
}
