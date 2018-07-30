package com.cg.paymentwalletjdbc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.paymentwalletjdbc.Exception.WalletException;
import com.cg.paymentwalletjdbc.dao.IWalletDao;
import com.cg.paymentwalletjdbc.dao.WalletDaoImpl;
import com.cg.paymentwalletjdbc.dto.Wallet;
import com.cg.paymentwalletjdbc.service.IWalletService;
import com.cg.paymentwalletjdbc.service.WalletServiceImpl;

public class ValidationTest {
IWalletService service=new WalletServiceImpl();
IWalletDao dao=new WalletDaoImpl();
	@Test
	public void CheckForZeroDeposittest() throws WalletException {
		boolean condition=false;
		Wallet wallet=new Wallet();
		wallet.setUserId("9789048238");
		dao.createAccount(wallet);
		condition=service.deposit("9789048238", 0.0);
		assertFalse(condition);
	}
	
	@Test
	public void CheckForValidDepositAmount() throws WalletException {
		boolean condition=false;
		Wallet wallet=new Wallet();
		wallet.setUserId("9789048238");
		dao.createAccount(wallet);
		condition=service.deposit("9789048238", 500);
		assertTrue(condition);
	}
	
	@Test (expected=WalletException.class)
	public void CheckForInvalidNameTest() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("fd65f46");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("ranjith");
		wallet.setPassword("12345678");
		service.validateDetails(wallet);
	}
	
	@Test
	public void CheckForValidNameTest() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("ranjith");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertTrue(condition);
	}
	
	@Test (expected=WalletException.class)
	public void CheckForInvalidPhoneNumberTest() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789");
		wallet.setEmailId("abcd@gmail.com");
		wallet.setUserId("ranjith");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertFalse(condition);
	}
	
	@Test
	public void CheckForValidPhoneNumberTest() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("ranjith");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertTrue(condition);
	}
	
	@Test (expected=WalletException.class)
	public void CheckForInvalidEmailTest() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("4gfgaff");
		wallet.setUserId("ranjith");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertFalse(condition);
	}
	
	@Test
	public void CheckForValidEmailTest() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("ranjith");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertTrue(condition);
	}

	@Test (expected=WalletException.class)
	public void CheckForInvalidUserId() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("abc");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertFalse(condition);
		
	}
	
	@Test 
	public void CheckForValidUserId() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("abcde");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertTrue(condition);
		
	}
	
	@Test (expected=WalletException.class)
	public void CheckForInvalidassword() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("abcde");
		wallet.setPassword("12345");
		boolean condition=service.validateDetails(wallet);
		assertFalse(condition);
		
	}
	
	@Test 
	public void CheckForValidPassword() throws WalletException {
		Wallet wallet=new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("9789789789");
		wallet.setEmailId("ranjith@gmail.com");
		wallet.setUserId("abcde");
		wallet.setPassword("12345678");
		boolean condition=service.validateDetails(wallet);
		assertTrue(condition);
		
	}
}
