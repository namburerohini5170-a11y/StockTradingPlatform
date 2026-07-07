import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Stock> market = new ArrayList<>();
        market.add(new Stock("TCS", 3500));
        market.add(new Stock("Infosys", 1600));
        market.add(new Stock("Wipro", 500));
        market.add(new Stock("Reliance", 2800));
        market.add(new Stock("HDFC Bank", 1700));

        Portfolio portfolio = new Portfolio();

        int choice;

        do {

            System.out.println("\n====== STOCK TRADING PLATFORM ======");
            System.out.println("1. Display Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Transaction History");
            System.out.println("6. Performance");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // MARKET
                case 1:
                    System.out.println("\n--- MARKET ---");
                    for (Stock s : market) {
                        System.out.println(s.getStockName() + " - ₹" + s.getPrice());
                    }
                    break;

                // BUY
                case 2:

                    for (int i = 0; i < market.size(); i++) {
                        System.out.println((i + 1) + ". " +
                                market.get(i).getStockName() +
                                " - ₹" + market.get(i).getPrice());
                    }

                    System.out.print("Enter stock number: ");
                    int idx = sc.nextInt();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    if (idx < 1 || idx > market.size()) {
                        System.out.println("Invalid stock number!");
                        break;
                        }

                    portfolio.addStock(market.get(idx - 1), qty);

                    System.out.println("BUY SUCCESS");
                    break;

                // SELL
                case 3:

                    System.out.print("Enter stock name: ");
                    String name = sc.next();

                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();

                    boolean result = portfolio.sellStock(name, sellQty);
                    

                    if (result) {
                        System.out.println("SELL SUCCESS");
                    }
                    break;

                // PORTFOLIO
                case 4:
                    portfolio.displayPortfolio();
                    break;

                // TRANSACTIONS
                case 5:
                    portfolio.showTransactions();
                    break;

                // PERFORMANCE
                case 6:
                    portfolio.showPerformance();
                    break;

                // EXIT
                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 7);

        sc.close();
    }
}