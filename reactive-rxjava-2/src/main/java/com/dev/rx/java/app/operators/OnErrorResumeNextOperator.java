package com.dev.rx.java.app.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class OnErrorResumeNextOperator {

	private static final Logger logger = LoggerFactory.getLogger(OnErrorResumeNextOperator.class);
	
	public static void main(String...strings) {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> 10 / i)
				.onErrorResumeNext(Observable.just(-1).repeat(3))
				.subscribe((i) -> logger.info("Received: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("onErrorResumeNext Example Two");
		onErrorResumeNextTwo();
		
		logger.info("onErrorResumeNext Example Three");
		onErrorResumeNextThree();
	}
	
	public static void onErrorResumeNextTwo() {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> 10 / i)
				.onErrorResumeNext(Observable.empty())
				.subscribe((i) -> logger.info("Received 2: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
	
	public static void onErrorResumeNextThree() {
		Observable.just(5, 2, 4, 0, 3, 2, 8)
				.map((i) -> 10 / i)
				.onErrorResumeNext((e) -> {
					return Observable.just(-1).repeat(3);
				})
				.subscribe((i) -> logger.info("Received 3: onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}