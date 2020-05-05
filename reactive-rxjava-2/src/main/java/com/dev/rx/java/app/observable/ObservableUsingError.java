package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingError {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingError.class);
	
	public static void main(String...strings) {
		Observable.error(new Exception("An Exception Occurred"))
				.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("Handle exception example 2");
		handleErrosOnLambda();
	}
	
	public static void handleErrosOnLambda() {
		Observable.error(() -> new Exception("An exception Occurred"))
				.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}
