package fr.sofnul.bk.demo.test.config;

import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.config.MethodInvokingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.sofnul.bk.demo.operation.IGetUserOp;
import fr.sofnul.bk.demo.operation.impl.GetUsersOp;
import fr.sofnul.bk.fmk.test.config.ServiceAppTestConfig;

@Configuration
@Import(ServiceAppTestConfig.class)
@EnableJpaRepositories("fr.sofnul.bk.demo.dao")
public class AppTestConfig {

	@Before
	public final void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Bean
	@DependsOn("dataSource")
	public MethodInvokingBean methodInvokingBean() {
		MethodInvokingBean m = new MethodInvokingBean();
		m.setTargetClass(DatabaseManagerSwing.class);
		m.setTargetMethod("main");
		m.setArguments(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
		return m;
	}

	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Bean
	public IGetUserOp getUserOp() {
		return new GetUsersOp();
	}

}