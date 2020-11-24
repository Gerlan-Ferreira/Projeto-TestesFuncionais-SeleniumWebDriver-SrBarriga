package testes;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import core.Propriedades;
import pages.ContasPage;
import pages.MenuPage;

/*Esse FixMethoOrder é para definir uma sequencia para execução dos testes. 
Dessa forma uso o NAME_ASCENDING parainformar que será em orde alfabética.*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesConta extends BaseTest {

	private ContasPage contasPage = new ContasPage();
	private MenuPage menuPage = new MenuPage();

	@Test
	public void test1_inserirConta() {

		menuPage.acessarTelaInserirContas();

		contasPage.setNomeConta("conta 1");

		contasPage.clicarBotaoSalvarConta();

		Assert.assertEquals("Conta adicionada com sucesso!", menuPage.obterMensagemSucesso());

	}

	@Test
	public void test2_alterarConta() {

		menuPage.acessarTelaListarContas();

		contasPage.clicarBotaoEditarConta("conta 1");

		contasPage.setNomeConta(Propriedades.NOME_CONTA_ALTERADA);

		contasPage.clicarBotaoSalvarConta();

		Assert.assertEquals("Conta alterada com sucesso!", menuPage.obterMensagemSucesso());

	}

	@Test
	public void test3_adicionarContaComMesmoNome() {

		menuPage.acessarTelaInserirContas();

		contasPage.setNomeConta(Propriedades.NOME_CONTA_ALTERADA);

		contasPage.clicarBotaoSalvarConta();

		Assert.assertEquals("Já existe uma conta com esse nome!", menuPage.obterMensagemFalha());

	}
	


}
