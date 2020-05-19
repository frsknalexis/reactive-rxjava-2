package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class AllOperator {

	private static final Logger logger = LoggerFactory.getLogger(AllOperator.class);
	
	public static void main(String...strings) {
		Observable.just(5, 3, 7, 11, 2, 14)
				.all((i) -> i < 10)
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}