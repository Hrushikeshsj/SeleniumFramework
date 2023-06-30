package dataproviders;

import constants.FrameworkConstants;
import org.testng.annotations.DataProvider;
import utilities.ExcelUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class OHRMDataProvider {
    private OHRMDataProvider(){}

    private static List<Map<String,String>> masterData = new ArrayList<>();


    @DataProvider (parallel = true)
    public static Object[] getLoginData(Method m){

        if(masterData.isEmpty()){
            masterData = ExcelUtils.ReadExcelFile(FrameworkConstants.getDATAPROVIDEREXCELFILEPATH(),"OHRM");
        }
        List<Map<String,String>> dataProvider = new ArrayList<>();

        for (int i=0;i< masterData.size();i++){
            if((masterData.get(i).get("name").equalsIgnoreCase(m.getName())) &&
                    (masterData.get(i).get("execution").equalsIgnoreCase("yes"))){
                dataProvider.add(masterData.get(i));

            }
        }


        return dataProvider.toArray();

    }

}
