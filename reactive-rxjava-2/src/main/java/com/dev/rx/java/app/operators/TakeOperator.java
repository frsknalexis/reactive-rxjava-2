package com.dev.rx.java.app.operators;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class TakeOperator {

	private static final Logger logger = LoggerFactory.getLogger(TakeOperator.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.take(3)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("Take operator example 2");
		takeOperatorExampleTwo();
	}
	
	public static void takeOperatorExampleTwo() throws InterruptedException {
		Observable.interval(300, TimeUnit.MILLISECONDS)
				.take(2, TimeUnit.SECONDS)
				.subscribe((l) -> logger.info("Received: onNext -> {}", l),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}