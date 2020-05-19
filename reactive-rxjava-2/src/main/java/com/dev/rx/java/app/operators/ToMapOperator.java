package com.dev.rx.java.app.operators;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ToMapOperator {

	private static final Logger logger = LoggerFactory.getLogger(ToMapOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap((s) -> s.charAt(0))
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
		
		logger.info("toMap Example Two");
		toMapExampleTwo();
		
		logger.info("toMap Example Three");
		toMapExampleThree();
		
		logger.info("toMap Example Four");
		toMapExampleFour();
		
		logger.info("toMultimap Example");
		toMultiMapExample();
	}
	
	public static void toMapExampleTwo() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap((s) -> s.charAt(0), String::length)
				.subscribe((v) -> logger.info("Received 2: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
	
	public static void toMapExampleThree() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap((s) -> s.charAt(0), String::length, () -> new ConcurrentHashMap<>())
				.subscribe((v) -> logger.info("Received 3: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
	
	public static void toMapExampleFour() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMap(String::length)
				.subscribe((v) -> logger.info("Received 4: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
	
	public static void toMultiMapExample() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toMultimap(String::length)
				.subscribe((v) -> logger.info("Received toMultimap: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}