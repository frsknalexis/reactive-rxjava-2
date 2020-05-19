package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ActionsOperator {

	private static final Logger logger = LoggerFactory.getLogger(ActionsOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.doOnSubscribe((d) -> logger.info("doOnSubscribe: Subscribing"))
				.doOnDispose(() -> logger.info("doOnDispose: Disposing!"))
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}