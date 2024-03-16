package org.Testinium;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.Testinium.PostPetBase;
import java.util.function.Function;


public class PostPet extends PostPetBase {
    public   String scenario;
    Function<String, String> file_Bath = str -> "src/test/resources/pets/"+scenario+".json";
    @Test
    public void PostPetHappyscenario() throws IOException {
        this.scenario ="PostPetBodyHappyScenario";
        String jsonContent = new String(Files.readAllBytes(Paths.get(file_Bath.apply(scenario))));

        String ActualName =AddNewPet_returnNameUponSuccess(jsonContent);

        Assert.assertEquals(ActualName,"doggieDoggo");
    }
}
