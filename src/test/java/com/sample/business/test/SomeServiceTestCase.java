package com.sample.business.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@ContextConfiguration(locations = { "classpath:spring/test-context.xml" })
public class SomeServiceTestCase extends AbstractJUnit4SpringContextTests {

	@Resource(name = "someService")
	//private SomeService someService;
}
