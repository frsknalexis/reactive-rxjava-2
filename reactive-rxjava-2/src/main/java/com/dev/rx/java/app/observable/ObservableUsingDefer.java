package com.dev.rx.java.app.observable;

import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

import org.slf4j.Logger;

public class ObservableUsingDefer {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingDefer.class);
	
	private static int start = 1;
	
	private static int count = 5;
	
	public static void main(String...strings) {
		Observable<Integer> source = Observable.range(start, count);
		source.subscribe((i) -> logger.info("Observer 1: onNext -> {}", i),
							(e) -> logger.info("onComplete -> {}", e),
							() -> logger.info("onComplete"));
		
		count = 10;
		source.subscribe((i) -> logger.info("Observer 2: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}
