package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingJust2 {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingJust2.class);
	
	public static void main(String...strings) {
		Observable<String> myString = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		myString.map(String::length)
				.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}
