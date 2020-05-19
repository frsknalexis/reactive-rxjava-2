package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class OnErrorReturn {

	private static final Logger logger = LoggerFactory.getLogger(OnErrorReturn.class);
	
	public static void main(String...strings) {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> 10 / i)
				.onErrorReturn((e) -> -1)
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("onError Example Two");
		onErrorExampleTwo();
	}
	
	public static void onErrorExampleTwo() {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> {
					try {
						return 10 / i;
					} catch (ArithmeticException e) {
						return -1;
					}
				})
				.subscribe((i) -> logger.info("Received 2: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}