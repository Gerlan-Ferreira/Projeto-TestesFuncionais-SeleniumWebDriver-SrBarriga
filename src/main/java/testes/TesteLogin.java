package testes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import core.BaseTestLogin;
import pages.LoginPage;

public class TesteLogin extends BaseTestLogin{
	
	private LoginPage pageLogin = new LoginPage();
	
	@Test
	public void validaLogin () {
		
		/*email e senha vazios*/
		pageLogin.setEmail("");
		pageLogin.setSenha("");
		pageLogin.entrarLogin();
		Assert.assertEquals("Email é um campo obrigatório", 
				pageLogin.obterTextoBy(By.xpath("//div[@role='alert'][1]")));
		Assert.assertEquals("Senha é um campo obrigatório", 
				pageLogin.obterTextoBy(By.xpath("//div[@role='alert'][2]")));
		
		
		/*com email mas senha vazia*/
		pageLogin.setEmail("gerlantest@email.com");
		pageLogin.setSenha("");
		pageLogin.entrarLogin();
		Assert.assertEquals("Senha é um campo obrigatório", 
				pageLogin.obterTextoBy(By.xpath("//div[@role='alert']")));
		
		
		/*e-mail vazio mas senha preenchida*/
		pageLogin.setEmail("");
		pageLogin.setSenha("123456");
		pageLogin.entrarLogin();
		Assert.assertEquals("Email é um campo obrigatório", 
				pageLogin.obterTextoBy(By.xpath("//div[@role='alert']")));
		
		
		/*e-mail e senha inexistentes*/
		pageLogin.setEmail("abel@email.com");
		pageLogin.setSenha("123456");
		pageLogin.entrarLogin();
		Assert.assertEquals("Problemas com o login do usuário", 
				pageLogin.obterTextoBy(By.xpath("//div[@role='alert']")));
		
		
		/*e-mail correto e senha errada*/
		pageLogin.setEmail("gerlantest@email.com");
		pageLogin.setSenha("123");
		pageLogin.entrarLogin();
		Assert.assertEquals("Problemas com o login do usuário", 
				pageLogin.obterTextoBy(By.xpath("//div[@role='alert']")));
		
		/*e-mail correto e senha correta*/
		pageLogin.setEmail("gerlantest@email.com");
		pageLogin.setSenha("123456");
		pageLogin.entrarLogin();
		Assert.assertEquals("Bem vindo, gerlan!", 
				pageLogin.obterTextoBy(By.xpath("//div[@role='alert']")));
		
	}

}
