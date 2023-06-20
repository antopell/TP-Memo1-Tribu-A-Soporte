package com.soporte.tpg_soporte;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber")
@ComponentScan("com.soporte.tpg_soporte")
@ContextConfiguration(classes = TpgSoporteApplication.class)
@SpringBootTest(classes=TpgSoporteApplication.class)
public class CucumberTest{
}
