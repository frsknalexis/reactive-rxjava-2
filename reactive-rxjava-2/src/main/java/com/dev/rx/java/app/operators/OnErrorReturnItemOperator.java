package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class OnErrorReturnItemOperator {

	private static final Logger logger = LoggerFactory.getLogger(OnErrorReturnItemOperator.class);
	
	public static void main(String...strings) {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> 10 / i)
				.onErrorReturnItem(-1)
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}