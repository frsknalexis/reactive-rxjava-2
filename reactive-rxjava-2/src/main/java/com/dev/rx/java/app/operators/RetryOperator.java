package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class RetryOperator {

	private static final Logger logger = LoggerFactory.getLogger(RetryOperator.class);
	
	public static void main(String...strings) {
		/*
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> 10 / i)
				.retry()
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		*/
		logger.info("retryTwoTimes Example");
		retryTwoTimes();
	}
	
	public static void retryTwoTimes() {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> 10 / i)
				.retry(2)
				.subscribe((i) -> logger.info("Received 2: onNext -> {}", i),
							(e) -> logger.error("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}