package pages;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class ResumoPage extends BasePage {

	public List<WebElement> verificarTamanhoTabela() {

		List<WebElement> lista = getDriver().findElements(By.xpath("//table[@id='tabelaExtrato']//tbody//tr"));

		return lista;
	}

}
