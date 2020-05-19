package com.dev.rx.java.app.operators;

import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ToListOperator {

	private static final Logger logger = LoggerFactory.getLogger(ToListOperator.class);
	
	public static void main(String...strings) {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toList()
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
		
		logger.info("toListOperatorTwo: ");
		toListOperatorTwo();
		logger.info("toListOperatorThree: ");
		toListOperatorThree();
		logger.info("toSortedListOperatorExampleFour: ");
		toSortedListOperatorExampleFour();
	}
	
	public static void toListOperatorTwo() {
		Observable.range(1, 1000)
				.toList(1000)
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
	
	public static void toListOperatorThree() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.toList(CopyOnWriteArrayList::new)
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
	
	public static void toSortedListOperatorExampleFour() {
		Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
				.toSortedList(Comparator.naturalOrder())
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}