package com.dev.rx.java.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableTwo {

	private static final Logger logger = LoggerFactory.getLogger(ConnectableObservableTwo.class);
	
	public static void main(String...strings) throws InterruptedException {
		ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
													.publish();
		source.subscribe((l) -> logger.info("Observer 1: onNext -> {}", l));
		source.connect();
		sleep(5000);
		
		source.subscribe((l) -> logger.info("Observer 2: onNext -> {}", l));
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}
