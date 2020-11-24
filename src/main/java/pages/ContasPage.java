package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ContasPage extends BasePage {

	/***************** Inserir conta **************************************/

	public void setNomeConta(String nomeConta) {

		escreve("nome", nomeConta);

	}

	public void clicarBotaoSalvarConta() {

		clicarBotaoBy(By.xpath("//button[.='Salvar']"));

	}



	/*********************** Alterar conta **************************************/

	public void clicarBotaoEditarConta(String valor) {
		
		ClicarBotaoTabela("Conta", valor, "Ações", "tabelaContas", "glyphicon glyphicon-edit");
		
	}
	
	public void clicarBotaoRemoverConta(String valor) {
		
		ClicarBotaoTabela("Conta", valor, "Ações", "tabelaContas", "glyphicon glyphicon-remove-circle");
		
	}

}
