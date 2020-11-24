package testes;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import core.Propriedades;
import pages.HomePage;
import pages.MenuPage;

public class TesteSaldo extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private HomePage homePage = new HomePage();

	@Test
	public void verificarSaldoConta() {

		menuPage.acessarTelaHome();
		
		System.out.println(homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
		Assert.assertEquals("100.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));

	}

}
