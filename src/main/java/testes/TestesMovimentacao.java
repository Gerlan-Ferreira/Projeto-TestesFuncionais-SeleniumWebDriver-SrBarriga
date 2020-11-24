package testes;

import static utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import core.Propriedades;
import pages.MenuPage;
import pages.MovimentacaoPage;
import utils.DataUtils;

/*Esse FixMethoOrder é para definir uma sequencia para execução dos testes. 
Dessa forma uso o NAME_ASCENDING parainformar que será em orde alfabética.*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesMovimentacao extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

	@Test
	public void test1_inserirMovimentacaoPaga() {

		menuPage.acessarTelaCriarMovimentacao();

		/* Inserindo receita paga */
		movimentacaoPage.selecionarTipoMovimentacao("Receita");
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movimentacaoPage.setDataPagamento(obterDataFormatada(new Date()));
		movimentacaoPage.setDescricao("Teste 1");
		movimentacaoPage.setInteressado("galego man");
		movimentacaoPage.setValor("100");
		movimentacaoPage.selecionarConta(Propriedades.NOME_CONTA_ALTERADA);
		movimentacaoPage.selecionarSituacaoPago();

		movimentacaoPage.clicarBotaoSalvarMovimentacao();

		Assert.assertEquals("Movimentação adicionada com sucesso!", menuPage.obterMensagemSucesso());

//		menuPage.acessarTelaCriarMovimentacao();
//		/* Inserindo despesa pendente */
//		movimentacaoPage.selecionarTipoMovimentacao("Despesa");
//		movimentacaoPage.setDataMovimentacao(obterDataFormatada(new Date()));
//		movimentacaoPage.setDataPagamento(obterDataFormatada(new Date()));
//		movimentacaoPage.setDescricao("Teste 2");
//		movimentacaoPage.setInteressado("galego man");
//		movimentacaoPage.setValor("200");
//		movimentacaoPage.selecionarConta(Propriedades.NOME_CONTA_ALTERADA);
//		movimentacaoPage.selecionarSituacaoPendente();
//
//		movimentacaoPage.clicarBotaoSalvarMovimentacao();
//
//		Assert.assertEquals("Movimentação adicionada com sucesso!", menuPage.obterMensagemSucesso());

	}

	@Test
	public void test2_validarCamposObrigatoriosMovimentacao() {

		menuPage.acessarTelaCriarMovimentacao();

		movimentacaoPage.clicarBotaoSalvarMovimentacao();

		List<String> erros = movimentacaoPage.obterMensagemErroCamposMovimentacao();
		
		//verificando se todos os valores que passei estao presentes na lista de erros
		Assert.assertTrue(
				erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
						"Descrição é obrigatório", "Interessado é obrigatório", "Valor é obrigatório", "Valor deve ser um número")));
		
		Assert.assertEquals(6, erros.size()); //checando o tamanho da lista se bate
	}

	@Test
	public void test3_inserirMovimentacaoFutura() {
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		

		menuPage.acessarTelaCriarMovimentacao();

		movimentacaoPage.selecionarTipoMovimentacao("Receita");
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movimentacaoPage.setDataPagamento(obterDataFormatada(dataFutura));
		movimentacaoPage.setDescricao("Teste movimentacao futura");
		movimentacaoPage.setInteressado("galego man");
		movimentacaoPage.setValor("666");
		movimentacaoPage.selecionarConta(Propriedades.NOME_CONTA_ALTERADA);
		movimentacaoPage.selecionarSituacaoPendente();

		movimentacaoPage.clicarBotaoSalvarMovimentacao();
		
		List<String> erros = movimentacaoPage.obterMensagemErroCamposMovimentacao();
		
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
	}


}
