package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableClass {

	private static final Logger logger = LoggerFactory.getLogger(ConnectableObservableClass.class);
	
	public static void main(String...strings) {
		ConnectableObservable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
														.publish();
		
		// subscriber 1
		source.subscribe((s) -> logger.info("Subscriber 1: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		// subscriber 2
		source.map(String::length)
			.subscribe((i) -> logger.info("Subscriber 2: onNext -> {}", i),
						(e) -> logger.info("onError -> {}", e.getMessage()),
						() -> logger.info("onComplete"));
		
		source.connect();
	}
}
