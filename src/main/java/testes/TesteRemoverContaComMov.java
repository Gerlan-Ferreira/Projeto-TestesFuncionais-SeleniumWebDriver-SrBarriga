package testes;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import core.Propriedades;
import pages.ContasPage;
import pages.MenuPage;

public class TesteRemoverContaComMov extends BaseTest{
	
	private ContasPage contasPage = new ContasPage();
	private MenuPage menuPage = new MenuPage();
	
	@Test
	public void removerContaComMovimentacao() {

		menuPage.acessarTelaListarContas();

		contasPage.clicarBotaoRemoverConta(Propriedades.NOME_CONTA_ALTERADA);

		Assert.assertEquals("Conta em uso na movimentações", menuPage.obterMensagemFalha());

	}


}
