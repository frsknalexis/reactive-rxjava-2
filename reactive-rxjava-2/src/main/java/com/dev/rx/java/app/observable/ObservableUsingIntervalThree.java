package com.dev.rx.java.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingIntervalThree {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingIntervalThree.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
		//observer 1
		seconds.subscribe((l) -> logger.info("Observer 1: onNext -> {}", l));
		sleep(5000);
		// observer 2
		seconds.subscribe((l) -> logger.info("Observer 2: onNext -> {}", l));
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}
