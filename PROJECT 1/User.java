public class User {
    private String name;
    private Portfolio portfolio;

    public User(String name, double initialCash) {
        this.name = name;
        this.portfolio = new Portfolio(initialCash);
    }

    // Buy stock
    public void buyStock(Market market, String ticker, int quantity) {
        ticker=ticker.toUpperCase();
        Stock stock = market.getStock(ticker);
        if (stock != null) {
            portfolio.buyStock(ticker, quantity, stock.getPrice());
        } else {
            System.out.println("Stock not found: " + ticker);
        }
    }

    // Sell stock
    public void sellStock(Market market, String ticker, int quantity) {
        ticker=ticker.toUpperCase();
        Stock stock = market.getStock(ticker);
        if (stock != null) {
            portfolio.sellStock(ticker, quantity, stock.getPrice());
        } else {
            System.out.println("Stock not found"+ ticker);
        }
    }

    // View portfolio value
    public void viewPortfolio(Market market) {
        System.out.println("Cash: $" + portfolio.getCash());
        System.out.println("Holdings: " + portfolio.getHoldings());
        System.out.println("Total Portfolio Value: $" + portfolio.getPortfolioValue(market));
    }
}
