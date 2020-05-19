package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ScanOperator {

	private static final Logger logger = LoggerFactory.getLogger(ScanOperator.class);
	
	public static void main(String...strings) {
		Observable.just(5, 3, 7, 10, 2, 14)
				.scan(Integer::sum)
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("scanOperatorWithInitialValue example 2");
		scanOperatorWithInitialValue();
	}
	
	public static void scanOperatorWithInitialValue() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.scan(0, (total, next) -> total + 1)
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}