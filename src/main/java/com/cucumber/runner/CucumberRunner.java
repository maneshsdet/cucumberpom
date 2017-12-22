package com.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {},
features = {"src\\test\\java\\com\\cucumber\\features"}
)
public class CucumberRunner {

}
