package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class SkipWhileOperator {

	private static final Logger logger = LoggerFactory.getLogger(SkipWhileOperator.class);
	
	public static void main(String...strings) {
		Observable.range(1, 100)
				.skipWhile((i) -> i <= 95)
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}