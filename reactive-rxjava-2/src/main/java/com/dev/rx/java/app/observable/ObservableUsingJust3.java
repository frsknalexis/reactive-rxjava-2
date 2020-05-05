package com.dev.rx.java.app.observable;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingJust3 {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingJust3.class);
	
	public static void main(String...strings) {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		source.map(String::length)
			.filter(i -> i >= 5)
			.subscribe((i) -> logger.info("Received: onNext -> {}", i),
						(e) -> logger.info("onError -> {}", e.getMessage()),
						() -> logger.info("onComplete"));
		
		logger.info("Observable using just with fromIterable operator example 2");
		justFactoryMethodUsingFromIterable();
	}
	
	public static void justFactoryMethodUsingFromIterable() {
		List<String> list = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		Observable<String> source = Observable.fromIterable(list);
		source.map(String::length)
			.filter((i) -> i >= 5)
			.subscribe((i) -> logger.info("Received: onNext -> {}", i),
						(e) -> logger.info("onError -> {}", e.getMessage()),
						() -> logger.info("onComplete"));
	}
}
