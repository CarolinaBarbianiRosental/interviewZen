package com.automacao.blogagi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeBlog {

	private WebDriver driver;

	public HomeBlog(WebDriver driver) {
		this.driver = driver;
	}

	public HomeBlog abrirSite() {
		driver.get("https://blogdoagi.com.br/");
		return this;
	}

	public void clicarLupa() {
		driver.findElement(By.id("search-open")).click();
	}

	public void inserirTexto(String texto) {
		WebElement element = driver.findElement(By.className("search-field"));
		element.sendKeys(texto);
		element.submit();
	}

	public String obtemResultadoValido() {
			return driver.findElement(By.className("archive-title")).getText();
	}
	
	public String obtemResultadoVazio() {
		WebElement element = driver.findElement(By.className("no-results"));
		return element.findElement(By.className("entry-header")).getText();
		
}
}
