package com.dev.rx.java.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingInterval {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingInterval.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);
		secondIntervals.subscribe((l) -> logger.info("onNext -> {}", l));
		
		sleep(5000);
	}
	
	private static void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}
}
