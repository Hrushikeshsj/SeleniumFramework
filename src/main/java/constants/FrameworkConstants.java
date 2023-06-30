package constants;

import java.time.Duration;

public class FrameworkConstants {
    private FrameworkConstants(){};

    private static final  String BASECONFIGFILEPATH = System.getProperty("user.dir")+"/src/test/resources/configs/baseConfig.properties";
    private static final Integer DEFAULTWAIT = 10;
    private static final String RUNMANAGERFILEPATH = System.getProperty("user.dir") + "/src/test/resources/runmanager/SeleniumTestsManager.xlsx";
    private static final String DATAPROVIDEREXCELFILEPATH = System.getProperty("user.dir") + "/src/test/resources/exceldataproviders/DataProviderExcel.xlsx";


    public static String getBASECONFIGFILEPATH() {
        return BASECONFIGFILEPATH;
    }
    public static String getDATAPROVIDEREXCELFILEPATH() {  return DATAPROVIDEREXCELFILEPATH;  }
    public static Duration getDEFAULTWAIT() {
        return Duration.ofSeconds(DEFAULTWAIT);
    }
    public static String getRUNMANAGERFILEPATH() { return RUNMANAGERFILEPATH; }

   }
