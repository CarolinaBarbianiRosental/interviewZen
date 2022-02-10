package com.automacao.blogagi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeBlog {
	
	private WebDriver driver;

	public HomeBlog(WebDriver driver) {
		this.driver = driver;
	}

	public HomeBlog abrirSite() {
		driver.get("https://blogdoagi.com.br/");
		return this;
	}
	
	

}
