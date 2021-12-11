import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

public class PortfolioTest {
    Portfolio portfolio;
    StockService stockService;

    public static void main(String[] args){
        PortfolioTest test = new PortfolioTest();
        test.setUp();
        System.out.println(test.testMarketValue() ? "Test passed" : "Test failed");
    }

    public void setUp(){
        //create a portfolio object which is to be tested
        portfolio = new Portfolio();

        //create the mock object of a stock service
        stockService = mock(StockService.class);

        //set the stockService to the portfolio
        portfolio.setStockService(stockService);
    }

    public boolean testMarketValue(){
        //create a list of stocks to be added to the portfolio
        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock appleStock = new Stock("2", "Apple", 100);

        stocks.add(googleStock);
        stocks.add(appleStock);

        //adding the stocks to our portfolio
        portfolio.setStocks(stocks);

        //mock the behaviours of the stock service to return
        //the value of various stock
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(appleStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        return marketValue == 100500.00;
    }
}
