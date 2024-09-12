import Extensions.UiActions;
import Utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResolverAutomationAssignment extends Helpers {

    @BeforeMethod
    public void SetupBeforeMethod() {
        //Navigates to the home page - demand that every test has at the beginning.
        webDriver.get(FILE_LOCATION_PREFIX + getDataFromXmlFile("TestsFileLocation"));
        /*
        Because 'DataConfig.xml' is in gitignore, you won't be able to see the content of it:
        <TestsFileLocation>C:\Users\User\Documents\Automation projects\ResolverTechnicalAssessment\src\main\resources\QE-index.html</TestsFileLocation>
         */
    }

    @Test
    public void test1() {
        //Assert that both the email address and password inputs are present as well as the login button
        webDriverWait.until(ExpectedConditions.visibilityOf(test1.input_email));
        Assert.assertTrue(test1.input_email.isDisplayed());

        webDriverWait.until(ExpectedConditions.visibilityOf(test1.input_password));
        Assert.assertTrue(test1.input_password.isDisplayed());

        webDriverWait.until(ExpectedConditions.visibilityOf(test1.btn_signInButton));
        Assert.assertTrue(test1.btn_signInButton.isDisplayed());

        //Enter an email address and password combination into the respective fields
        UiActions.writeTextToWebElement(test1.input_email, "moran.liv2006@gmail.com");
        UiActions.writeTextToWebElement(test1.input_password, generateAlphaNumericValue(15));
    }

    @Test
    public void test2() {
        //In the test 2 div, assert that there are three values in the listgroup
        Assert.assertEquals(test2.list_listGroup.size(), 3);

        //Assert that the second list item's value is set to "List Item 2"
        //There are 2 ways to verify that the second list item value is "List Item 2"
        Assert.assertEquals(UiActions.getTextFromElement(test2.list_listGroup.get(1)).split("6")[0].trim(),
                "List Item 2");
        Assert.assertTrue(UiActions.getTextFromElement(test2.list_listGroup.get(1)).contains("List Item 2"));

        //Assert that the second list item's badge value is 6
        Assert.assertEquals(UiActions.getTextFromElement(test2.text_secondItemBadge), "6");

    }

    @Test
    public void test3() {
        //Because the test and his elements are below the opening screen position, I had to scroll to the element, so I'll be able to do actions on it.
        UiActions.scrollToElement(test3.btn_dropdownMenu);

        //In the test 3 div, assert that "Option 1" is the default selected value
        //default selected value is the value that is presented in the dropdown button without doing any actions on it
        Assert.assertEquals(UiActions.getTextFromElement(test3.btn_dropdownMenu), "Option 1");

        //Select "Option 3" from the select list
        UiActions.chooseDropdownMenuOptionByValue(test3.btn_dropdownMenu, test3.btn_option3Button);

        //My addition to verify that "Option 3" was selected
        Assert.assertEquals(UiActions.getTextFromElement(test3.btn_dropdownMenu), "Option 3");
    }

    @Test
    public void test4() {
        //Because the test and his elements are below the opening screen position, I had to scroll to the element, so I'll be able to do actions on it.
        UiActions.scrollToElement(test4.btn_primaryButton);

        //In the test 4 div, assert that the first button is enabled
        Assert.assertTrue(test4.btn_primaryButton.isEnabled());

        //and that the second button is disabled
        //both ways:
        Assert.assertTrue(!test4.btn_secondaryButton.isEnabled());
        Assert.assertFalse(test4.btn_secondaryButton.isEnabled());
    }

    @Test
    public void test5() {
        //In the test 5 div, wait for a button to be displayed (note: the delay is random) and then click it

        /*The UiActions.clickWebElement method contains elementToBeClickable expected wait condition,
        so it doesn't matter how long it's going to take until the element will be displayed, he will wait for it.
        */
        UiActions.clickWebElement(test5.btn_test5Button);

        //Once the test5.btn_test5Button element is displayed, we can scroll the screen to it.
        UiActions.scrollToElement(test5.btn_test5Button);

        //Once you've clicked the button, assert that a success message is displayed
        Assert.assertTrue(test5.txt_test5Alert.isDisplayed());
        Assert.assertEquals(UiActions.getTextFromElement(test5.txt_test5Alert), "You clicked a button!");

        //Assert that the button is now disabled, both ways:
        Assert.assertFalse(test5.btn_test5Button.isEnabled());
        Assert.assertTrue(!test5.btn_test5Button.isEnabled());
    }

    @Test
    public void test6() {
        int rowIndex = 2;
        int colIndex = 2;
        WebElement webElement = null;
        try {
            String matrixCellSelector = getCssSelectorPathOfSpecificCell(rowIndex, colIndex);
            System.out.println("The full css selector of a specific cell within the matrix is: " + matrixCellSelector);
            webElement = webDriver.findElement(By.cssSelector(matrixCellSelector));
            if ((rowIndex == 2) && (colIndex == 2)) {
                //Only if the selected cell is (2,2) then verify his value
                Assert.assertEquals(UiActions.getTextFromElement(webElement), "Ventosanzap");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            //I put here "Assert.fail" because without it, you won't have any indication that the test has been failed, because of the "catch" section.
            Assert.fail(exception.getMessage());
            /*For example - there is no cell in position (4,2), so you're getting exception error -
            NoSuchElementException:no such element: Unable to locate element:
            {"method":"css selector","selector":"#test-6-div > div > table > tbody > tr:nth-child(5) > td:nth-child(3)"}
            and without the "fail", the test would look like his passed.
             */
        }
    }
}

