package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleObservable {

	private static final Logger logger = LoggerFactory.getLogger(SingleObservable.class);
	
	public static void main(String...strings) {
		Single.just("Hello")
			.map(String::length)
			.subscribe((i) -> logger.info("onSuccess -> {}", i),
						(e) -> logger.info("onError -> {}", e.getMessage()));
		
		logger.info("Single Observable using first operator example 1");
		singleUsingFirstOperator();
	}
	
	public static void singleUsingFirstOperator() {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
		source.first("Nil")
			.subscribe((s) -> logger.info("onSuccess -> {}", s),
						(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}
