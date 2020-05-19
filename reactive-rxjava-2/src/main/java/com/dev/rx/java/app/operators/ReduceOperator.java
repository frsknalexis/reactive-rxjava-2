package com.dev.rx.java.app.operators;

import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

import org.slf4j.Logger;

public class ReduceOperator {

	private static final Logger logger = LoggerFactory.getLogger(ReduceOperator.class);
	
	public static void main(String...strings) {
		Observable.just(5, 3, 7, 10, 2, 14)
				.reduce(Integer::sum)
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()), 
							() -> logger.info("onComplete"));
		
		logger.info("reduceOperator Example 2");
		reduceOperatorExample2();
	}
	
	public static void reduceOperatorExample2() {
		Observable.just(5, 3, 7, 10, 2, 14)
				.reduce("", (total, next) -> total + (total.equals("") ? "": ",") + next)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}