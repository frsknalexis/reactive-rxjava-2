package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DoOnCompleteOperator {

	private static final Logger logger = LoggerFactory.getLogger(DoOnCompleteOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.doOnComplete(() -> logger.info("doOnComplete: Source is done emitting!"))
				.map(String::length)
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}