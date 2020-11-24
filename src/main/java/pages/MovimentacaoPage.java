package pages;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void selecionarTipoMovimentacao(String tipo) {

		selecionarCombo("tipo", tipo);

	}

	public void setDataMovimentacao(String data) {

		escreve("data_transacao", data);
	}

	public void setDataPagamento(String data) {

		escreve("data_pagamento", data);
	}

	public void setDescricao(String descricao) {

		escreve("descricao", descricao);
	}

	public void setInteressado(String interessado) {

		escreve("interessado", interessado);
	}

	public void setValor(String valor) {

		escreve("valor", valor);

	}

	public void selecionarConta(String nome_conta) {

		selecionarCombo("conta", nome_conta);

	}

	public void selecionarSituacaoPago() {

		clicarRadio("status_pago");

	}

	public void selecionarSituacaoPendente() {

		clicarRadio("status_pendente");

	}
	
	public void clicarBotaoSalvarMovimentacao() {
		
		clicarBotaoBy(By.xpath("//button[.='Salvar']"));
		
	}
	
	/*Criando uma lista para obter as mensagens de erro da tela de movimentacao*/
	public List <String> obterMensagemErroCamposMovimentacao() {
		
		List <WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		
		List <String> retorno = new ArrayList <String>();
		
		for (WebElement erro: erros) {
			
			retorno.add(erro.getText());
			
		}
		return retorno;
	}
	public void selecionarMesMovimentacao(String mes) {
		selecionarCombo("mes", mes);
	}
	
	public void selecionarAnoMovimentacao(String ano) {
		selecionarCombo("ano", ano);
	}
	
	public void clicarBotaoBuscarMovimentacao() {
		clicarBotaoBy(By.xpath("//input[@value='Buscar']"));
	}
	
	public void clicarBotaoRemoverMovimentacao(String valor) {
		
		ClicarBotaoTabela("Conta", valor, "Ações", "tabelaExtrato", "glyphicon glyphicon-remove-circle");
		
	}
}
