package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import core.Propriedades.TipoExecucao;

public class DriverFactory {

	private static WebDriver driver;

	/* Método para Instanciar o driver */
	public static WebDriver getDriver() {
		/*
		 * O método está estático para que não precise instanciar ele nas outras classes
		 * ao chamar.
		 */

		if (driver == null) {
			/*
			 * Criando um switch para qual browser irá ser executado de acordo com o que foi
			 * setado na Enum
			 */
			if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
				switch (Propriedades.BROWSER) {

				case FIREFOX:

					driver = new FirefoxDriver();

					break;

				case CHROME:

					driver = new ChromeDriver();

					break;
				}
			}
			/* Criando uma forma de executar remota pelo selenium grid */
			if (Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {

				DesiredCapabilities cap = null;

				switch (Propriedades.BROWSER) {

				case FIREFOX:

					cap = DesiredCapabilities.firefox();

					break;

				case CHROME:

					cap = DesiredCapabilities.chrome();

					break;
				}

				try {
					driver = new RemoteWebDriver(new URL("http://192.168.0.9:4444/wd/hub"), cap);
				} catch (MalformedURLException e) {
					System.out.println("Falha na conexão com o GRID");
					e.printStackTrace();
				}
			}
			/* Criando uma forma de executar remota pelo SauceLab na Nuvem */
			if (Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {

				DesiredCapabilities cap = null;

				switch (Propriedades.BROWSER) {

				case FIREFOX:

					cap = DesiredCapabilities.firefox();

					break;

				case CHROME:

					cap = DesiredCapabilities.chrome();

					break;
				}

				try {
					driver = new RemoteWebDriver(new URL(
							"https://gerlan.ferreira.menew:997b1d2c-e7f5-4c99-be1c-115742e40340@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
							cap);
				} catch (MalformedURLException e) {
					System.out.println("Falha na conexão com o GRID");
					e.printStackTrace();
				}
			}
			driver.manage().window().maximize();

		}

		return driver;
	}

	/* Método para Finalizar o driver */
	public static void killDriver() {

		if (driver != null) {

			driver.quit();
			driver = null;

		}
	}

}
