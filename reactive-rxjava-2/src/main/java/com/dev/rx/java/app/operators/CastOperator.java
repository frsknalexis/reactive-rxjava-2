package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class CastOperator {

	private static final Logger logger = LoggerFactory.getLogger(CastOperator.class);
	
	public static void main(String...strings) {
		Observable<Object> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
											.cast(Object.class);
		
		source.subscribe((o) -> logger.info("Received: onNext -> {}", o),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}