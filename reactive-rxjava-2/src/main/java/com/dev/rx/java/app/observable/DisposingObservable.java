package com.dev.rx.java.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DisposingObservable {

	private static final Logger logger = LoggerFactory.getLogger(DisposingObservable.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
		Disposable disposable = source.subscribe((i) -> logger.info("onNext -> {}", i),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		// sleep 5 seconds
		sleep(5000);
		// dispose and stop the emissions
		disposable.dispose();
		// sleep 5 seconds to prove there are no more emissions
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}
