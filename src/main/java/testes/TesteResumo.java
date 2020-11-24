package testes;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import core.Propriedades;
import pages.MenuPage;
import pages.MovimentacaoPage;
import pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteResumo extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1_removerMovimentacao() {

		/*
		 * Date dataFutura = DataUtils.obterDataComDiferencaDias(-30);
		 * 
		 * Inserindo conta para ser excluída logo em seguida
		 * menuPage.acessarTelaCriarMovimentacao();
		 * movimentacaoPage.selecionarTipoMovimentacao("Receita");
		 * movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		 * movimentacaoPage.setDataPagamento(obterDataFormatada(dataFutura));
		 * movimentacaoPage.setDescricao("Teste Excluir");
		 * movimentacaoPage.setInteressado("galego man");
		 * movimentacaoPage.setValor("300");
		 * movimentacaoPage.selecionarConta(Propriedades.NOME_CONTA_ALTERADA);
		 * movimentacaoPage.selecionarSituacaoPago();
		 * 
		 * movimentacaoPage.clicarBotaoSalvarMovimentacao();
		 */

		/* Excluindo a conta inserida anteriormente */
		menuPage.acessarTelaResumoMensal();
		movimentacaoPage.selecionarMesMovimentacao("Julho");
		movimentacaoPage.selecionarAnoMovimentacao("2020");
		movimentacaoPage.clicarBotaoBuscarMovimentacao();
		movimentacaoPage.clicarBotaoRemoverMovimentacao(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Movimentação removida com sucesso!", menuPage.obterMensagemSucesso());

	}

	@Test
	public void test2_ResumoMensal() {

		menuPage.acessarTelaResumoMensal();

		movimentacaoPage.selecionarMesMovimentacao("Julho");
		movimentacaoPage.selecionarAnoMovimentacao("2020");
		movimentacaoPage.clicarBotaoBuscarMovimentacao();
		System.out.println(resumoPage.verificarTamanhoTabela().size());
		Assert.assertEquals(0, resumoPage.verificarTamanhoTabela().size());

	}
}
