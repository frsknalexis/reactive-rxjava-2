package com.dev.rx.java.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingIntervalTwo {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingIntervalTwo.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable.interval(1, TimeUnit.SECONDS)
				.subscribe((l) -> logger.info("onNext -> {}", l));
		
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}
