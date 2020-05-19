package com.dev.rx.java.app.operators;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class SortedOperator {

	private static final Logger logger = LoggerFactory.getLogger(SortedOperator.class);
	
	public static void main(String...strings) {
		Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
				.sorted()
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("sortedOperatorUsingComparator example 2");
		sortedOperatorUsingComparator();
		logger.info("sortedOperationWithLambdaExpression example 3");
		sortedOperationWithLambdaExpression();
	}
	
	public static void sortedOperatorUsingComparator() {
		Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
				.sorted(Comparator.reverseOrder())
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
	
	public static void sortedOperationWithLambdaExpression() {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.sorted((x, y) -> Integer.compare(x.length(), y.length()))
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}