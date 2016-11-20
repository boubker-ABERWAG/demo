package fr.sofnul.bk.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.MethodInvokingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.sofnul.bk.demo.component.IUserManagmentComponent;
import fr.sofnul.bk.demo.component.impl.UserManagmentComponentImpl;
import fr.sofnul.bk.demo.operation.IGetUserOp;
import fr.sofnul.bk.demo.operation.impl.GetUsersOp;
import fr.sofnul.bk.demo.service.IUserManagmentService;
import fr.sofnul.bk.demo.service.impl.UserManagmentService;

@Configuration
@EnableJpaRepositories("fr.sofnul.bk.demo.dao")
@EnableTransactionManagement
public class AppConfig {

	// @SuppressWarnings("restriction")
	// @PostConstruct
	// public void startDBManager() {
	// // hsqldb
	// DatabaseManagerSwing.main(new String[] { "--url",
	// "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	// }

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
		return builder.setType(EmbeddedDatabaseType.HSQL).addScript("classpath:db/sql/create-db.sql").addScript("classpath:db/sql/insert-data.sql").build();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabase(Database.HSQL);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public JpaTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public IUserManagmentService userManagmentService() {
		return new UserManagmentService();
	}

	@Bean
	public IUserManagmentComponent userManagmentComponent() {
		return new UserManagmentComponentImpl();
	}

	@Bean
	public IGetUserOp getUserOperation() {
		return new GetUsersOp();
	}

}
