package com.psqframework.core.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.psqframework.core.element.BaseElement;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;

public class BasePage extends PageObject {

	public static final Logger Log = LoggerFactory.getLogger(BasePage.class);

	public String URL;

	public int defaultTimeout = 90 * 1000;

	public void sleep(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
		}
	}

	public void invoke() {
		// TODO URL not set
		super.openUrl(URL);
	}

	public void invoke(String URL) {
		this.URL = URL;
		invoke();
	}

	public BaseElement getItemToExist() {
		return null;
	}


	@WhenPageOpens
	public void waitForMe() {

		if (getItemToExist() == null)
			return;

		try {
			getItemToExist().waitForMe(defaultTimeout);
		}
		catch (Exception e)	{
			throw new AssertionError(String.format("Page '%s' was not loaded. Waited %d ms for object '%s' to appear",  this.toString(), defaultTimeout, getItemToExist())) ;
		}

	}

}
