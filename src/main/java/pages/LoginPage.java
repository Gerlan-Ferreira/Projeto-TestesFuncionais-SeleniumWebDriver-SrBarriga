package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class LoginPage extends BasePage {
	
	public void setEmail(String email) {
		
		escreve("email", email);
		
	}
	
	public void setSenha(String senha) {
		
		escreve("senha", senha);
		
	}
	
	public void entrarLogin() {
		
		clicarBotaoBy(By.xpath("//button[.='Entrar']"));
		
	}
	
	

}
