package owaspJuiceShop.genericUiKeywords;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GenericUiKeyWords {

    /**
     * Author
     * Rim Gammoudi
     */

    protected  Page page;
    public GenericUiKeyWords(Page page)
    {
        this.page=page;
    }


    //Generic methods useful to use in page classes

    //Method useful to find element in the DOM UI
    public Locator findWebElement(Locator locator) {
    return locator;

    }

    //Method useful to click In WebElement

    public void clickInElement(Locator locator) {

        findWebElement(locator).click();
    }

    //Method useful to clear Text in webElement

    public void clearText(Locator locator) {

        findWebElement(locator).clear();
    }


    //Method useful to extract text of an input
    public String extractTextContentOfInput(Locator locator) {

        return findWebElement(locator).textContent();
    }


    //Method useful to send text in webElement

    public void fillInWebElement(Locator locator, String valueToFill) {

        if (extractTextContentOfInput(locator).isEmpty()) {
            findWebElement(locator).fill(valueToFill);
        } else {
            clearText(locator);
            findWebElement(locator).fill(valueToFill);
        }


    }


    //Method useful to hover In webElement
    public void hoverInWebElement(String locator) {

        page.locator(locator).hover();

    }

    //Method useful to hover In webElement
    public void hoverInWebElement(String locator, String attributeName) {

        page.locator(locator).getAttribute(attributeName);

    }

    //Method useful to extract the list of webElements
    public List<Locator> extractTheWebElements(String locator) {
        List<Locator> dropDown;
        return dropDown = page.locator(locator).all();
    }

    //Method useful to click the right value of dropdown
    public void clickTheValueOfDropDown(String locator, String valueToSearch) {
        List<Locator> listOfDropDown;
        listOfDropDown = extractTheWebElements(locator);
        if (!listOfDropDown.isEmpty()) {
            for (Locator element : listOfDropDown) {
                if (element.textContent().equalsIgnoreCase(valueToSearch)) {
                    element.click();
                }
            }
        }
    }

    //Method useful to extract the actual webUrl
    public String extractWebUrl() {
        return page.url();

    }

    //Method useful to relaod the page
    public void reloadThePage()
    {

        page.reload();

    }

    //Method useful to scroll into element
    public void scrollIntoWebElement(Locator locator)
    {

        locator.scrollIntoViewIfNeeded();

    }

    //Method useful to verify if the web element is visible in DOM
    public boolean verifyIfWebElementIsVisibleInDom(Locator locator)
    {

        return findWebElement(locator).isVisible();
    }

    //Method useful to verify if the web element is checked
    public boolean verifyIfWebElementIsChecked(Locator locator)
    {

        return findWebElement(locator).isChecked();
    }

    //Method useful to verify if the web element is disabled
    public boolean verifyIfWebElementIsDisabled(Locator locator)
    {

        return findWebElement(locator).isDisabled();
    }

    //Method useful to verify if the web element is enabled
    public boolean verifyIfWebElementIsEnabled(Locator locator)
    {

        return findWebElement(locator).isEnabled();
    }


    public static String getCurrentLocalDate() {
       /* LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return now.format(formatter);*/
      return   Instant.now().toString();
    }



}






