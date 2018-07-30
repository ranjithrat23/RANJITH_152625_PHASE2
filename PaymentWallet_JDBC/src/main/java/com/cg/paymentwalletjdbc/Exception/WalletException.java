package com.cg.paymentwalletjdbc.Exception;


public class WalletException extends Exception{
	private static final long serialVersionUID = 1L;

	public WalletException() {
		super();
	}

	public WalletException(String message) {
		System.out.println(message);
	}
}
