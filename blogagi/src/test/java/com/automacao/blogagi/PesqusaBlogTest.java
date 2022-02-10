package com.automacao.blogagi;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PesqusaBlogTest {

	public WebDriver driver;
	public HomeBlog homeblog;

	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Windows\\chromedriver_win32\\chromedrive\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@After
	public void fecharNavegador() {
		driver.quit();
	}

	@Test
	public void pesquisaAssuntoValido() {
		homeblog = new HomeBlog(driver);

		homeblog.abrirSite();
		homeblog.clicarLupa();
		homeblog.inserirTexto("Fabrica");
		String resultado = homeblog.obtemResultadoValido();
		System.out.println(resultado);
		Assert.assertEquals(resultado, "Resultados da busca por: Fabrica");
	}

	@Test
	public void pesquisaAssuntoNaoEncontrado(){
		homeblog = new HomeBlog(driver);

		homeblog.abrirSite();
		homeblog.clicarLupa();
		homeblog.inserirTexto("Testes Automatizados");
		String resultado = homeblog.obtemResultadoVazio();
		System.out.println(resultado);
		Assert.assertEquals(resultado, "Nenhum resultado");

	}

}
