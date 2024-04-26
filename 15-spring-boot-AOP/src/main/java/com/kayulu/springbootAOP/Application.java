package com.kayulu.springbootAOP;

import com.kayulu.springbootAOP.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private Account account;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		Account account = new Account();
		accountDAO.setName("Premium Account");
		accountDAO.setServiceCode("234");

		accountDAO.addAccount(account, true);
		accountDAO.synchronizeAccount();

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();


	}
}
