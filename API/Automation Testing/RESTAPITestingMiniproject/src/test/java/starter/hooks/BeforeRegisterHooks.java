package starter.hooks;

import io.cucumber.java.Before;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class BeforeRegisterHooks {
    @Before
    public static void beforeTest() {
        String email = "someone@mail.com";
        String password = "123123";
        String name = "gaming";
        String description= "for gaming purposes";


        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("name", name);
        requestBody.put("description", description);


        String filePath = "src/test/resources/sample/user.json";

        try {
            String jsonString = requestBody.toString();

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}