package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class SwitchIfEmptyOperator {

	private static final Logger logger = LoggerFactory.getLogger(SwitchIfEmptyOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.filter((s) -> s.startsWith("Z"))
				.switchIfEmpty(Observable.just("Zeta", "Eta", "Theta"))
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}