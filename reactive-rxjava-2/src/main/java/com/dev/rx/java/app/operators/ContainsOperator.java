package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ContainsOperator {

	private static final Logger logger = LoggerFactory.getLogger(ContainsOperator.class);
	
	public static void main(String...strings) {
		Observable.range(1, 10000)
				.contains(9563)
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}