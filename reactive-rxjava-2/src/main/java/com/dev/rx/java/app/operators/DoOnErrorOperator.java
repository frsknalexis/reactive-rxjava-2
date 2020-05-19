package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DoOnErrorOperator {

	private static final Logger logger = LoggerFactory.getLogger(DoOnErrorOperator.class);
	
	public static void main(String...strings) {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.doOnError((e) -> logger.info("doOnError: Source failed -> {}", e.getMessage()))
				.map((i) -> 10 / i)
				.doOnError((e) -> logger.info("doOnError: Division failed! -> {}", e.getMessage()))
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}