package Data;

import Models.BookingDates;
import Models.BookingRequest;
import org.testng.annotations.DataProvider;

public class dp {

    @DataProvider(name = "dataProviderDP")
    public Object[][] parameters() {

        BookingDates dates1 = new BookingDates("2023-01-01", "2023-02-14");
        BookingRequest details1 = new BookingRequest("Auditore", "Ezio",123, true, dates1, "Family", 800, null);

        BookingDates dates2 = new BookingDates("2023-01-01", "2023-02-13");
        BookingRequest details2 = new BookingRequest("Miles", "Desmond", 123, true, dates2, "Life", 700, null);

        return new Object[][] {
                {details1},
                {details2}
        };
    }
}
