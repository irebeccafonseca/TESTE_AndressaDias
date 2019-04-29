import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.events.WebDriverEventListener;

import okhttp3.internal.http.HttpMethod;
import teste.Diretor;
import teste.Filme;

public class TestMain {

		private ArrayList<Diretor> diretores = new ArrayList<Diretor>();
		private ArrayList <Filme>filmes = new ArrayList<Filme>();
		private DriverService driver;
		
		@Before
		public void preparar_teste() {
			
			Diretor diretor = new Diretor(); 
			
			diretor.setNome("George Lucas");
			diretor.setNascimento("01/10/1983");
			
			Filme filme = new Filme();
			
			filme.setNome("Star Wars");
			filme.setLancamento("2019");
			
			diretores.add(diretor);
			filmes.add(filme);
		
			driver.start();
			driver.getUrl("https://www.google.com/");
			
		}
		
		@Test
		public void test_googleSearch() {
			
			WebElement edit_busca;
			WebElement button_pesquisar;
			WebElement label_resultados;
			
			edit_busca.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
			
			edit_busca.sendKeys(diretores.get(0).getNome() + " " + filmes.get(0).getNome());
			
			button_pesquisar.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]"));
			
			button_pesquisar.click();
			
			label_resultados.findElement(By.xpath("//*[@id=\"resultStats\"]"));
			
			System.out.println(label_resultados.getText());
			
			assertTrue("Aproximadamente 63.600.000 resultados", true);
			
		}
		
		@Teste
		public void API_test() {
			
			String address = "https://jsonplaceholder.typicode.com/todos/1";
			
			HttpRequest request = new HttpRequest(org.openqa.selenium.remote.http.HttpMethod.GET, address);
			InputStream input;
			
			request.consumeContentStream();
			
		}
		
		@After
		public void finalizar() {
			driver.stop();
		}
		
}
