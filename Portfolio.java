import java.util.ArrayList;

public class Portfolio {

    private ArrayList<Stock> stocks = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    // BUY STOCK
    public void addStock(Stock stock, int qty) {

        for (int i = 0; i < stocks.size(); i++) {

            if (stocks.get(i).getStockName().equalsIgnoreCase(stock.getStockName())) {

                quantities.set(i, quantities.get(i) + qty);

                // Store BUY transaction
                transactions.add(new Transaction(stock.getStockName(), qty, "BUY"));

                System.out.println("Updated " + stock.getStockName() + " quantity");
                return;
            }
        }

        stocks.add(stock);
        quantities.add(qty);

        // Store BUY transaction
        transactions.add(new Transaction(stock.getStockName(), qty, "BUY"));

        System.out.println(stock.getStockName() + " added (" + qty + " shares)");
    }

    // SELL STOCK
    public boolean sellStock(String name, int qty) {

        for (int i = 0; i < stocks.size(); i++) {

            if (stocks.get(i).getStockName().equalsIgnoreCase(name)) {

                int currentQty = quantities.get(i);

                if (qty > currentQty) {
                    System.out.println("Not enough stock to sell!");
                    return false;
                }

                int newQty = currentQty - qty;
                quantities.set(i, newQty);

                // Store SELL transaction
                transactions.add(new Transaction(name, qty, "SELL"));

                System.out.println("Sold " + qty + " shares of " + name);

                if (newQty == 0) {
                    stocks.remove(i);
                    quantities.remove(i);
                }

                return true;
            }
        }

        return false;
    }

    // VIEW PORTFOLIO
    public void displayPortfolio() {

        if (stocks.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }

        System.out.println("\n----- PORTFOLIO -----");

        for (int i = 0; i < stocks.size(); i++) {
            System.out.println(
                    stocks.get(i).getStockName()
                    + " | Quantity : "
                    + quantities.get(i)
                    + " | Price : ₹"
                    + stocks.get(i).getPrice());
        }
    }

    // TRANSACTION HISTORY
    public void showTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n----- TRANSACTION HISTORY -----");

        for (Transaction t : transactions) {
            t.display();
        }
    }

    // PERFORMANCE
    public void showPerformance() {

        double totalValue = 0;

        for (int i = 0; i < stocks.size(); i++) {
            totalValue += stocks.get(i).getPrice() * quantities.get(i);
        }

        System.out.println("\n----- PERFORMANCE -----");
        System.out.println("Total Different Stocks : " + stocks.size());

        int totalShares = 0;
        for (int q : quantities) {
            totalShares += q;
        }

        System.out.println("Total Shares Held : " + totalShares);
        System.out.println("Portfolio Value : ₹" + totalValue);
    }
}