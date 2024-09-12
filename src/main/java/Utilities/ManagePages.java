package Utilities;

import PageObjects.*;
import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    public static void initPages() {
        test1 = PageFactory.initElements(webDriver, Test1.class);
        test2 = PageFactory.initElements(webDriver, Test2.class);
        test3 = PageFactory.initElements(webDriver, Test3.class);
        test4 = PageFactory.initElements(webDriver, Test4.class);
        test5 = PageFactory.initElements(webDriver, Test5.class);
    }
}
