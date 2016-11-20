package fr.sofnul.bk.demo.test.operation;

import java.io.InputStream;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import fr.sofnul.bk.demo.bo.Users;
import fr.sofnul.bk.demo.operation.IGetUserOp;
import fr.sofnul.bk.demo.test.config.AppTestConfig;
import fr.sofnul.bk.fmk.test.operation.AbstractOperationTest;

@ContextConfiguration(classes = AppTestConfig.class, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class UserOperationTest extends AbstractOperationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserOperationTest.class);

	@Autowired
	private IGetUserOp getUserOp;

	@Test
	public void testGetUsers() {
		@SuppressWarnings("unchecked")
		List<Users> userList = (List<Users>) getUserOp.process();
		userList.stream().forEach(l -> LOGGER.info("ID : {} , Name : {} , EMail : {}", l.getId(), l.getName(), l.getEmail()));
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("db/sql/Users.xml");
		return new FlatXmlDataSetBuilder().build(in);
	}

}
