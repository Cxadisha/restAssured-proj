import Data.Data;
import Response.ListByNameResponse;
import Step.StepClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class GetListTest {

    StepClass step = new StepClass();


    @Test
    public void getList() throws FileNotFoundException {

        ListByNameResponse list = step.getList(Data.NAME);
        System.out.println(list.toString());

    }
}
