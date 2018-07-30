package com.cg.paymentwalletjdbc.dao;

import java.util.ArrayList;

import com.cg.paymentwalletjdbc.Exception.WalletException;
import com.cg.paymentwalletjdbc.dto.Wallet;

public interface IWalletDao {
	public int createAccount(Wallet wallet) throws WalletException;

	public double showBalance(String userId);

	public void deposit(String userId, double amount);

	public void withdraw(String userId, double amount);

	public boolean fundTransfer(String userIdSender, String userIdReceiver, double amount) throws WalletException;

	public ArrayList<String> printTransactions(String userId);

	public String login(String id, String password) throws WalletException;
}
