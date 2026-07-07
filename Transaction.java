public class Transaction {

    String stockName;
    int quantity;
    String type;

    public Transaction(String stockName, int quantity, String type) {
        this.stockName = stockName;
        this.quantity = quantity;
        this.type = type;
    }

    public void display() {
        System.out.println(type + " - " + stockName + " - " + quantity);
    }
}
