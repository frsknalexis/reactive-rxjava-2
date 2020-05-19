package com.dev.rx.java.app.operators;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class CollectOperator {

	private static final Logger logger = LoggerFactory.getLogger(CollectOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.collect(() -> new HashSet<>(), HashSet::add)
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
			
	}
}