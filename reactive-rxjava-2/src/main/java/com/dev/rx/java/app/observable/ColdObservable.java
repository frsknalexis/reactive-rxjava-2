package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ColdObservable {

	private static final Logger logger = LoggerFactory.getLogger(ColdObservable.class);
	
	public static void main(String...strings) {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		// observer 1
		source.subscribe((s) -> logger.info("Observer 1: onNext -> {}", s));
		// observer 2
		source.subscribe((s) -> logger.info("Observer 2: onNext -> {}", s));
		
		logger.info("Cold Observable example 2");
		coldObservableFactoryTwo();
	}
	
	public static void coldObservableFactoryTwo() {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		// first observer
		source.subscribe((s) -> logger.info("Observer 1: onNext -> {}", s));
		// second observer
		source.map(String::length)
			.filter(i -> i >= 5)
			.subscribe((i) -> logger.info("Observer 2: onNext -> {}", i));
	}
}
