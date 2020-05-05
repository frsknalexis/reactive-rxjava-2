package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingRange {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingRange.class);
	
	public static void main(String...strings) {
		Observable<Integer> source = Observable.range(1, 10);
		source.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("Range Factory Example two");
		rangeFactoryTwo();
	}
	
	public static void rangeFactoryTwo() {
		Observable<Integer> source = Observable.range(5, 10);
		source.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}
