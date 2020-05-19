package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class StartWithOperator {

	private static final Logger logger = LoggerFactory.getLogger(StartWithOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Coffee", "Tea", "Espresso", "Latte")
				.startWith("COFFEE SHOP MENU")
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("startWithArrayOperator example");
		startWithArrayOperator();
	}
	
	public static void startWithArrayOperator() {
		Observable.just("Coffee", "Tea", "Espresso", "Latte")
				.startWithArray("COFFEE SHOP MENU", "----------------")
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}