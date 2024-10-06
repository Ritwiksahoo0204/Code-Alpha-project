import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private double cash;

    public Portfolio(double initialCash) {
        this.cash = initialCash;
    }

    // Buy stocks
    public void buyStock(String ticker, int quantity, double price) {
        if (cash >= price * quantity) {
            holdings.put(ticker, holdings.getOrDefault(ticker, 0) + quantity);
            cash -= price * quantity;
            System.out.println("Bought " + quantity + " shares of " + ticker);
        } else {
            System.out.println("Not enough cash to buy " + ticker);
        }
    }

    // Sell stocks
    public void sellStock(String ticker, int quantity, double price) {
        if (holdings.getOrDefault(ticker, 0) >= quantity) {
            holdings.put(ticker, holdings.get(ticker) - quantity);
            cash += price * quantity;
            System.out.println("Sold " + quantity + " shares of " + ticker);
        } else {
            System.out.println("Not enough shares to sell " + ticker);
        }
    }

    // Get total portfolio value
    public double getPortfolioValue(Market market) {
        double totalValue = cash;
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            String ticker = entry.getKey();
            int quantity = entry.getValue();
            Stock stock = market.getStock(ticker);
            totalValue += stock.getPrice() * quantity;
        }
        return totalValue;
    }

    // Getters
    public double getCash() {
        return cash;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }
}
