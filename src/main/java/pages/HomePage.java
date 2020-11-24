package pages;

import core.BasePage;

public class HomePage extends BasePage {
	
	
	public String obterSaldoConta (String nome_conta) {
		
		return obterTextoCelulaTabela("Conta", nome_conta, "Saldo", "tabelaSaldo");
		
	}

}
