package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DistinctOperator {

	private static final Logger logger = LoggerFactory.getLogger(DistinctOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.map(String::length)
				.distinct()
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("distinct operator example 2");
		distinctOperatorTwo();
	}
	
	public static void distinctOperatorTwo() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.distinct(String::length)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
	}
}