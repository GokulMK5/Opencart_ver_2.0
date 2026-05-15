package org.utilityPackage;



import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1

    @DataProvider(name = "LoginData")
    public String[][] getloginData() throws IOException {

        String path = System.getProperty("user.dir") + "/testdata/allTestdata.xlsx"; // taking xl file from testData

        ExcelUtils xlutil = new ExcelUtils(path); // creating an object for XLUtility

        int totalrows = xlutil.getRowCount("loginsheet");
        int totalcols = xlutil.getCellCount("loginsheet", 1);

        String logindata[][] = new String[totalrows][totalcols]; // created for two dimension array which can store the data

        for (int i = 1; i <= totalrows; i++) // 1  // read the data from xl storing in two dimensional array
        {
            for (int j = 0; j < totalcols; j++) // 0   i is rows j is col
            {
                logindata[i - 1][j] = xlutil.getCellData("loginsheet", i, j); // 1,0
            }
        }

        return logindata; // returning two dimension array
    }
}