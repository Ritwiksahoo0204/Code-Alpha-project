import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market();
        User user = new User("John Doe", 10000.00);  // Starting with $10,000

        boolean exit = false;
        System.out.println("-------Stock Trading Platform-------");
        while (!exit) {
            System.out.println("\n1. View Market Prices");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Update Market Prices");
            System.out.println("6. Exit\n");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Market Prices:");
                    market.getStockPrices().forEach((ticker, stock) -> 
                        System.out.println(ticker + ": $" + stock.getPrice()));
                    break;
                case 2:
                    System.out.print("Enter Stock Ticker: ");
                    String buyTicker = scanner.next();
                    System.out.print("Enter Quantity: ");
                    int buyQuantity = scanner.nextInt();
                    user.buyStock(market, buyTicker, buyQuantity);
                    break;
                case 3:
                    System.out.print("Enter Stock Ticker: ");
                    String sellTicker = scanner.next();
                    System.out.print("Enter Quantity: ");
                    int sellQuantity = scanner.nextInt();
                    user.sellStock(market, sellTicker, sellQuantity);
                    break;
                case 4:
                    user.viewPortfolio(market);
                    break;
                case 5:
                    market.updatePrices();
                    System.out.println("Market prices updated.");
                    break;
                case 6:
                    System.out.println("......Exiting the program......");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}
