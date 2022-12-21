package pages;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.get(), this);

    }

    public static List<Map<String,String>> getExcelData(){

        ExcelUtil libraryFile = new ExcelUtil("src/test/resources/LibraryCT_Credentials_EU_projects.xlsx","sheet2");

        return libraryFile.getDataList();
    }

    @ParameterizedTest
    @MethodSource("getExcelData")
    public static void login(Map<String,String> user){

        Driver.get().get("https://library1.cydeo.com/");




    }

}
