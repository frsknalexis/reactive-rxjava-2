package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DistinctUntilChangeOperator {

	private static final Logger logger = LoggerFactory.getLogger(DistinctUntilChangeOperator.class);
	
	public static void main(String...strings) {
		Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
				.distinctUntilChanged()
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("distinctUntilChanged example 2");
		distinctUntilChangedTwo();
	}
	
	public static void distinctUntilChangedTwo() {
		Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
				.distinctUntilChanged(String::length)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
			
	}
}