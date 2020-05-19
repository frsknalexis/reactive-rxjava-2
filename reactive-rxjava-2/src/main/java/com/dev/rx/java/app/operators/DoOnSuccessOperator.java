package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DoOnSuccessOperator {

	private static final Logger logger = LoggerFactory.getLogger(DoOnSuccessOperator.class);
	
	public static void main(String...strings) {
		Observable.just(5, 3, 7, 10, 2, 14)
				.reduce(Integer::sum)
				.doOnSuccess((i) -> logger.info("doOnSuccess -> {}", i))
				.subscribe((v) -> logger.info("Received: onSuccess -> {}", v),
							(e) -> logger.info("onError ->  {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}