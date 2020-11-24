package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTestLogin {
	
	@Before
	public void inicializa() {
		
		getDriver().get("https://seubarriga.wcaquino.me/login");
		
	}

	@Rule
	public TestName testNameLogin = new TestName();
	
	@After
	public void finaliza() throws IOException { 
		
		/*Esse método faz com que ao final dos testes seja tirado um print da tela*/
		TakesScreenshot print_tela = (TakesScreenshot) getDriver();
		
		/*Pegando o print retornado pelo TakeScreenshot e transformando em um arquivo*/
		File arquivo_print = print_tela.getScreenshotAs(OutputType.FILE);
		
		/*Usando o FileUtils para poder transformar o arquivo pego em uma foto .jpg*/
		FileUtils.copyFile(arquivo_print, new File ( "target" + File.separator + "screenshotsLogin" + File.separator +
				testNameLogin.getMethodName() + ".jpg"));
		
		if (Propriedades.FECHAR_BROWSER) {
			
			killDriver();
			
		}
		
	}
}
