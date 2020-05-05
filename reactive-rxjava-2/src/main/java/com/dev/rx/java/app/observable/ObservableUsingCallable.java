package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingCallable {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingCallable.class);
	
	public static void main(String...strings) {
		/*
		Observable.just(1 / 0)
				.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		*/
		logger.info("Observable using Callable example 1");
		observableUsingCallableFactory();
	}
	
	public static void observableUsingCallableFactory() {
		Observable.fromCallable(() -> 1 / 0)
				.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}
