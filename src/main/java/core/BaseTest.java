package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*Classe criada para servir como Herança para as classes de testes que forem usar
 * e herdam tudo aqui criado.*/
public class BaseTest {

	//private LoginPage pageLogin = new LoginPage();

//	@Before
//	public void inicializa() {
//
//		getDriver().get("https://seubarriga.wcaquino.me");
//
//		pageLogin.setEmail("gerlantest@email.com");
//
//		pageLogin.setSenha("123456");
//
//		pageLogin.entrarLogin();
//		
//	}

	@Rule
	public TestName testName = new TestName();
	/*
	 * Essa Rule faz com que pegue os nomes de cada teste para ser usado nos prints
	 * das telas ao final de cada teste.
	 */

	@After
	public void finaliza() throws IOException {

		/* Esse método faz com que ao final dos testes seja tirado um print da tela */
		TakesScreenshot print_tela = (TakesScreenshot) getDriver();

		/*
		 * Pegando o print retornado pelo TakeScreenshot e transformando em um arquivo
		 */
		File arquivo_print = print_tela.getScreenshotAs(OutputType.FILE);

		/* Usando o FileUtils para poder transformar o arquivo pego em uma foto .jpg */
		FileUtils.copyFile(arquivo_print, new File(
				"target" + File.separator + "screenshots" + File.separator + testName.getMethodName() + ".jpg"));

		/*
		 * Esse IF faz com que verifique se o browser vai ou nao fechar uma instancia
		 * para cada teste, o mesmo é definido na classe Propriedades com um valor
		 * booleano, se for false ele irá fechar ao final dos testes, e se for True será
		 * ao contrário, ou seja para cada teste será uma instancia do browser.
		 */
		if (Propriedades.FECHAR_BROWSER) {

			killDriver();

		}

	}

}
