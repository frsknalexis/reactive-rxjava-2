package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingNever {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingNever.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable<String> emptySource = Observable.never();
		emptySource.subscribe((s) -> logger.info("onNext -> {}", s),
								Throwable::getMessage,
								() -> logger.info("onComplete"));
		
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}
