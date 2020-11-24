package suites;

import static core.DriverFactory.getDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import pages.LoginPage;
import testes.TesteRemoverContaComMov;
import testes.TesteResumo;
import testes.TesteSaldo;
import testes.TestesConta;
import testes.TestesMovimentacao;

@RunWith(Suite.class)
@SuiteClasses({
	TestesConta.class,
	TestesMovimentacao.class,
	TesteRemoverContaComMov.class,
	TesteSaldo.class,
	TesteResumo.class
	
}) 
public class SuiteGeral {
	
	private static LoginPage pageLogin = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {

		getDriver().get("https://seubarriga.wcaquino.me");

		pageLogin.setEmail("gerlantest@email.com");

		pageLogin.setSenha("123456");

		pageLogin.entrarLogin();
		
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}




}
