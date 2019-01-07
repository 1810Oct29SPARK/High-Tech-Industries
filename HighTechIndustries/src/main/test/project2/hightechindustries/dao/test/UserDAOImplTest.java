package project2.hightechindustries.dao.test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class UserDAOImplTest {
	
	public static void main(String[] args) {

	      //Create a portfolio object which is to be tested		
	      Portfolio portfolio = new Portfolio();

	      //Creates a list of stocks to be added to the portfolio
	      List<Users> stocks = new ArrayList<Users>();
	      Stock billy = new User("Billy", "Bob", null, null, "Customer", null, null, null, null, null);
	      Stock john = new User("Johnney", "Faker", null, null, "Customer", null, null, null, null, null);

	      stocks.add(billy);
	      stocks.add(john);		

	      //Create the mock object of stock service
	      StockService stockServiceMock = mock(StockService.class);

	      // mock the behavior of stock service to return the value of various sto
	      when(stockServiceMock.getFirstname(billy)).thenReturn("Billy");
	      when(stockServiceMock.getFirstname(john)).thenReturn("Johnney");

	      //add stocks to the portfolio
	      portfolio.setStocks(stocks);

	      //set the stockService to the portfolio
	      portfolio.setStockService(stockServiceMock);

	      double marketValue = portfolio.getMarketValue();

	      //verify the market value to be 
	      //10*50.00 + 100* 1000.00 = 500.00 + 100000.00 = 100500
	      System.out.println("Market value of the portfolio: "+ marketValue);
	}

}
