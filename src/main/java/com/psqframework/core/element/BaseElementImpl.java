package com.psqframework.core.element;

import static net.serenitybdd.core.pages.WebElementExpectations.elementIsEnabled;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.psqframework.core.page.BasePage;

import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;

public class BaseElementImpl extends WebElementFacadeImpl implements BaseElement {

	public static final Logger Log = LoggerFactory.getLogger(BasePage.class);

	public BaseElementImpl(final WebDriver driver, final ElementLocator locator,
			final long implicitTimeoutInMilliseconds) {
		super(driver, locator, null, implicitTimeoutInMilliseconds, implicitTimeoutInMilliseconds);
	}

	public BaseElementImpl(final WebDriver driver, final ElementLocator locator,
			final long implicitTimeoutInMilliseconds, final long waitForTimeoutInMilliseconds) {
		super(driver, locator, null, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
	}

	public void fill(String text) {
		waitForMe();
		super.type(text);
	}

	public String getFill() {
		waitForMe();
		return super.getTextValue();
	}

	public boolean exists(int timeoutMilliSeconds) {
		
        try {
        	waitForMe(timeoutMilliSeconds);
        } catch (Exception e) {
     
        	return false;
        }
     
		return isVisible();
	}

	public boolean exists() {
		return exists((int) (long)this.timeoutInMilliseconds());
	}

	
	public void waitForMe(int timeoutMilliSeconds) {
		Log.info(String.format("Waiting for %s to become enabled with a timeout of %d", this.toString(), timeoutMilliSeconds));
		
		withTimeoutOf(timeoutMilliSeconds, TimeUnit.MILLISECONDS).waitUntilEnabled();
	}
	
	public void waitForMe() {
		waitForMe((int) (long)this.timeoutInMilliseconds());
	}


}