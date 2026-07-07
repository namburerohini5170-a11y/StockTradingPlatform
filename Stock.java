public class Stock {

    private String stockName;
    private double price;

    // Constructor
    public Stock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    // Getter methods
    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }

    // Display stock details
    public void displayStock() {
        System.out.println("Stock Name : " + stockName);
        System.out.println("Price      : ₹" + price);
    }
}