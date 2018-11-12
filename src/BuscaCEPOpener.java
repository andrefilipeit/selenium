import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscaCEPOpener {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		//Put the geckodriver.exe on directory c:\\
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		/**
		 * Use for open Google Chrome
		 * System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 * 
		 */
		
		// Visit the Correios web page
		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaLogBairro.cfm");

		// Choice the UF value
		Select selectUF = new Select(driver.findElement(By.name("UF")));
		selectUF.selectByVisibleText("RJ");
		// Fill the field 'Localidade' with the value  "Rio de Janeiro"
		WebElement inputLocalidade = driver.findElement(By.name("Localidade"));
		inputLocalidade.sendKeys("Rio de Janeiro");
		// Fill the field 'Bairro' with the value "Copacabana"
		WebElement inputBairro = driver.findElement(By.name("Bairro"));
		inputBairro.sendKeys("Copacabana");

		// click on button 'Buscar'
		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonBuscar.click();

		
		//Before the button click, verify if exists any text equal this : DADOS ENCONTRADOS COM SUCESSO.
		String codigoPagina = driver.getPageSource();
		if(codigoPagina.contains("DADOS ENCONTRADOS COM SUCESSO.")){
			//Try show a popup on the browser
		}
		
		/**
		 * Explicit Wait
		 * WebDriverWait wait = new WebDriverWait(driver, 30); WebElement
		 * divResultados =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
		 * ("div.srg")));
		 * 
		 * assertNotNull(divResultados);
		 * 
		 * As linhas em destaque mostram o Explicit Wait. Utilizamos a classe WebDriverWait que nos permite esperar até que (until()) uma condição ocorra – no nosso caso, a div esteja presente. Se o timeout de 30 segundos expirar (segundo argumento do construtor WebDriverWait), é lançada uma exceção TimeoutException e o teste vai falhar.
		 */
		
		/**
		 * Implicit Wait
  		 *	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 *
		 * driver.get("http://www.google.com.br");
		 * driver.findElement(By.name("q")).sendKeys("testes de aceitação");
		 *
		 * assertNotNull(driver.findElement(By.cssSelector("div.srg")));
		 * 
		 * A linha em destaque configura um Implicit Wait de 30 segundos. Com isso, daí pra frente, toda tentativa de encontrar um elemento na página, como o findElement do exemplo, vai ser feita por até 30 segundos antes de que seja lançada uma NoSuchElementException.
		 */
	}

}
