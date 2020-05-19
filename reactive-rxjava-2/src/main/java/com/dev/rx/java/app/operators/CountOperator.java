package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class CountOperator {

	private static final Logger logger = LoggerFactory.getLogger(CountOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.count()
				.subscribe((l) -> logger.info("Received: onNext -> {}", l),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}