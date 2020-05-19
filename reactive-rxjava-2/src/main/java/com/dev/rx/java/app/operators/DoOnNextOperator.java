package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DoOnNextOperator {

	private static final Logger logger = LoggerFactory.getLogger(DoOnNextOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.doOnNext((s) -> logger.info("Processing: -> {}", s))
				.map(String::length)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("doAfterNextOperator Example Two: ");
		doAfterNextOperator();
	}
	
	public static void doAfterNextOperator() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.doAfterNext((s) -> logger.info("Received: doAfterNext -> {}", s))
				.map(String::length)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
						(e) -> logger.info("onError -> {}", e.getMessage()),
						() -> logger.info("onComplete"));
	}
}