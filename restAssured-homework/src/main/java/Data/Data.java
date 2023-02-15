package Data;

import java.util.UUID;
import java.util.Random;

public class Data {
    static Random random = new Random();

    public static int ID = random.nextInt(5, 100);
    public static final String URL = "https://bookstore.toolsqa.com/Account/v1";
    public static final String userName = UUID.randomUUID().toString();
    public static final String password = "!@#$wefsd231#%@[]dsadASA2";
    public static final String SUCCESS = "Success";
    public static final String RESULT = "User authorized successfully.";
}
