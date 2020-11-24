package core;

public class Propriedades {

	/*
	 * Esse método vai ser usado para definir se o browser vai ou nao ficar fechando
	 * uma instancia para cadas teste. Se for FALSE ele irá fechar ao final dos
	 * testes, e se for TRUE será ao contrário, ou seja para cada teste será uma
	 * instancia do browser.
	 */
	public static boolean FECHAR_BROWSER = false;
	
	/* Criando o método para que por padrão os testes sejam executados no Chrome. */
	public static Browsers BROWSER = Browsers.FIREFOX;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.NUVEM;

	/* Criado uma constante para usar essa variável nos testes e não precisar está limpando toda vez 
	 a informação no banco.*/
	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();
	
	/* Criando uma Enum para definir o nome dos browsers que irei usar. */
	public enum Browsers {
		CHROME, FIREFOX
	}
	
	public enum TipoExecucao {
		LOCAL, 
		GRID,
		NUVEM
	}

}
