package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaHome() {
		clicarLink("Home");
	}

	public void acessarTelaInserirContas() {

		clicarLink("Contas");
		clicarLink("Adicionar");

	}

	public void acessarTelaListarContas() {

		clicarLink("Contas");
		clicarLink("Listar");

	}

	public void acessarTelaCriarMovimentacao() {

		clicarLink("Criar Movimentação");

	}
	
	public void acessarTelaResumoMensal() {

		clicarLink("Resumo Mensal");

	}

	public void acessarTelaLogout() {

		clicarLink("Sair");

	}
	
	/** Obter mensagem sucesso e falha **/

	public String obterMensagemSucesso() {

		return obterTextoBy(By.xpath("//div[@class='alert alert-success']"));

	}

	public String obterMensagemFalha() {

		return obterTextoBy(By.xpath("//div[@class='alert alert-danger']"));
	}

}
