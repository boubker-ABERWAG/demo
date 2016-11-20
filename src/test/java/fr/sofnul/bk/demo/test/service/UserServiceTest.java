package fr.sofnul.bk.demo.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import fr.sofnul.bk.demo.test.config.AppTestConfig;
import fr.sofnul.bk.fmk.test.service.AbstractServiceTest;

@ContextConfiguration(classes = AppTestConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends AbstractServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

}
