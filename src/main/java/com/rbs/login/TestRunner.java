package com.rbs.login;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
					features = "features",
					glue="classpath:com.rbs.login.StepDef"
				)

public class TestRunner
{
} 
