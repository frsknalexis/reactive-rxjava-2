package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ElementAtOperator {

	private static final Logger logger = LoggerFactory.getLogger(ElementAtOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
				.elementAt(3)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s), 
							(e) -> logger.info("onError -> {}", e.getMessage()), 
							() -> logger.info("onComplete"));
	}
}