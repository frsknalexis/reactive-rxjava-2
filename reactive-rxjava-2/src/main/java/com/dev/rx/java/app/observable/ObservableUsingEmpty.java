package com.dev.rx.java.app.observable;

import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

import org.slf4j.Logger;

public class ObservableUsingEmpty {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingEmpty.class);
	
	public static void main(String...strings) {
		Observable<String> sourceEmpty = Observable.empty();
		sourceEmpty.subscribe((s) -> logger.info("onNext -> {}", s),
								Throwable::getMessage,
								() -> logger.info("onComplete"));
	}
}
