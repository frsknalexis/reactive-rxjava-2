package com.dev.rx.java.app.operators;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DelayOperator {

	private static final Logger logger = LoggerFactory.getLogger(DelayOperator.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
				.delay(3, TimeUnit.SECONDS)
				.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}