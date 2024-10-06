import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Market {
    private Map<String, Stock> stockMarket = new LinkedHashMap<>();
    private Random random = new Random();

    public Market() {
        // Add some stocks to the market
        stockMarket.put("BARSHA", new Stock("BARSHA", 150.00));
        stockMarket.put("MOTOROLA", new Stock("MOTOROLA", 2800.00));
        stockMarket.put("UBON", new Stock("UBON", 750.00));
        stockMarket.put("ASUS", new Stock("ASUS", 3400.00));
    }

    // Simulate price changes
    public void updatePrices() {
        for (Stock stock : stockMarket.values()) {
            double change = random.nextDouble() * 10 - 5;  // Random price change between -5 and 5
            stock.setPrice(stock.getPrice() + change);
        }
    }

    // Get current stock prices
    public Map<String, Stock> getStockPrices() {
        return stockMarket;
    }

    // Get specific stock by ticker
    public Stock getStock(String ticker) {
        return stockMarket.get(ticker);
    }
}
