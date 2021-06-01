import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "pretty", "json:target/cucumber-report/report.json"},
        features = "src/test/ru/assaulov/features",
        glue = "ru.assaulov.stepdefs"
)
public class CucumberRunner {

    @BeforeClass
    public static void setup() throws IOException {
        Files.walk(Paths.get("D:\\Education\\Test Automation\\AutoTraining\\allure-report"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);

        Files.walk(Paths.get("D:\\Education\\Test Automation\\AutoTraining\\allure-results"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);

    }
}


