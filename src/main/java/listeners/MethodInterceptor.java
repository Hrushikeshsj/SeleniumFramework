package listeners;

import constants.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import utilities.ExcelUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> Result = new ArrayList<>();
        List<Map<String,String>> lists = ExcelUtils.ReadExcelFile(FrameworkConstants.getRUNMANAGERFILEPATH(),"RUNMANAGER");

        for (int i=0;i<methods.size();i++){
            for (int j=0;j< lists.size();j++){
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(lists.get(j).get("name"))){
                    if (lists.get(j).get("execution").equalsIgnoreCase("yes")){
                        Result.add(methods.get(i));
                    }
                    methods.get(i).getMethod().setDescription(lists.get(j).get("description"));
                    methods.get(i).getMethod().setPriority(Integer.parseInt(lists.get(j).get("priority")));
                }

            }
        }

       return Result;
    }
}
