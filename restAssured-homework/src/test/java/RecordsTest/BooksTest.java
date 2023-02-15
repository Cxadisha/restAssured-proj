package RecordsTest;

import Steps.RecordSteps;
import io.qameta.allure.Step;
import org.junit.Test;

public class BooksTest {

    RecordSteps steps = new RecordSteps();

    @Test
    public void  RecordTest() {

        steps.validateBooksSize().validateGeneratedToken().validateAuthorization();

    }
}
