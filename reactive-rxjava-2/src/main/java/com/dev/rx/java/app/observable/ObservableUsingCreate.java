package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class ObservableUsingCreate {

	private static final Logger logger = LoggerFactory.getLogger(ObservableUsingCreate.class);
	
	public static void main(String...strings) {
		Observable<String> source = Observable.create((emitter) -> {
			emitter.onNext("Alpha");
			emitter.onNext("Beta");
			emitter.onNext("Gamma");
			emitter.onNext("Delta");
			emitter.onNext("Epsilon");
			emitter.onComplete();
		});
		
		source.subscribe((s) -> logger.info("Received: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
		
		logger.info("Observable using create example 2");
		createFactoryTwo();
		
		logger.info("Observable using create example 3");
		createFactoryMethodThree();
	}
	
	public static void createFactoryTwo() {
		Observable<String> source = Observable.create((emitter) -> {
			try {
				emitter.onNext("Alpha");
				emitter.onNext("Beta");
				emitter.onNext("Gamma");
				emitter.onNext("Delta");
				emitter.onNext("Epsilon");
				emitter.onComplete();
			} catch(Throwable t) {
				emitter.onError(t);
			}
		});
		
		source.subscribe((s) -> logger.info("RECEIVED: onNext -> {}", s),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
	
	public static void createFactoryMethodThree() {
		Observable<String> source = Observable.create((emitter) -> {
			try {
				emitter.onNext("Alpha");
				emitter.onNext("Beta");
				emitter.onNext("Gamma");
				emitter.onNext("Delta");
				emitter.onNext("Epsilon");
				emitter.onComplete();
			} catch(Throwable t) {
				emitter.onError(t);
			}
		});
		
		source.map(String::length)
			.filter((i) -> i >= 5)
			.subscribe((i) -> logger.info("Received: onNext -> {}", i),
						(e) -> logger.info("onError -> {}", e),
						() -> logger.info("onComplete"));
	}
}