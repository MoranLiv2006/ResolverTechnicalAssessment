package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Helpers extends Base {

    protected String generateAlphaNumericValue(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    protected String getCssSelectorPathOfSpecificCell(int rowIndex, int colIndex) {
        return String.format("#test-6-div > div > table > tbody > tr:nth-child(%d) > td:nth-child(%d)",
                rowIndex + 1, colIndex + 1);
        //I had to increase the index's by 1 because you wanted that the upper left element will be (0,0) while the HTML elements are starting from (1,1)
    }
}
