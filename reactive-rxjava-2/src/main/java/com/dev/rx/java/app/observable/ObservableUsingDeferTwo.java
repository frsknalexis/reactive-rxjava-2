package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingDeferTwo {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingDeferTwo.class);
	
	private static int start = 1;
	
	private static int count = 5;
	
	public static void main(String...strings) {
		Observable<Integer> source = Observable.defer(() -> Observable.range(start, count));
		source.subscribe((i) -> logger.info("Observer 1: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		// modify count
		count = 10;
		source.subscribe((i) -> logger.info("Observer 2: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}
