package com.kayulu.springbootAOP;

import com.kayulu.springbootAOP.dao.AccountDAO;
import com.kayulu.springbootAOP.service.TrafficFortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	@Autowired
	private Account account;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, TrafficFortune fortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoAfterAdvice(accountDAO);
			demoAroundAdvice(fortuneService);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		Account account = new Account();
		account.setName("Premium Account");
		account.setLevel("Ultimate");

		accountDAO.addAccount(account, true);
		accountDAO.addAccount(account, true);
		accountDAO.addAccount(account, true);
		accountDAO.addAccount(account, true);
		accountDAO.addAccount(account, true);

		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAccounts();
			for (Account tmpAccount : accountList)
				System.out.println(tmpAccount.getName());

		} catch (Exception e) {
			System.out.println("[main] ====> Exception: "+ e.getCause());
        }
    }

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAccounts(true);

		} catch (Exception e) {
			System.out.println("[main] ====> Exception: "+ e.getCause());
		}

	}

	private void demoAfterAdvice(AccountDAO accountDAO) {
		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAccounts(true);

		} catch (Exception e) {
			System.out.println("[main] ====> Exception: "+ e.getCause());
		}

	}

	private void demoAroundAdvice(TrafficFortune trafficFortune) {
		System.out.println("[main] ====> Fortune: " + trafficFortune.getFortune());
	}
}
