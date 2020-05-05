package com.dev.rx.java.app.observable;

import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import org.slf4j.Logger;

public class CreatingObserver {

	private static final Logger logger = LoggerFactory.getLogger(CreatingObserver.class);
	
	public static void main(String...strings) {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		
		Observer<Integer> myObserver = new Observer<Integer>() {
			
			@Override
			public void onSubscribe(Disposable d) {
				logger.info("onSubscribe");
			}
			
			@Override
			public void onNext(Integer t) {
				logger.info("Received: onNext -> {}", t);
			}
			
			@Override
			public void onError(Throwable e) {
				logger.info("onError -> {}", e.getMessage());
			}
			
			@Override
			public void onComplete() {
				logger.info("onComplete");
			}
		};
		
		source.map(String::length)
			.filter(i -> i >= 5)
			.subscribe(myObserver);
		
		logger.info("Creating Observers example 1");
		creatingObserversUsingLambdas();
		logger.info("Creating Observers example 2");
		creatingObserversUsingLambdasTwo();
		logger.info("Creating Observers example 3");
		creatingObserverUsingLambdasThree();
	}
	
	public static void creatingObserversUsingLambdas() {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		source.map(String::length)
			.filter(i -> i >= 5)
			.subscribe((i) -> logger.info("Received: onNext -> {}", i),
						Throwable::getMessage,
						() -> logger.info("Done!"));
	}
	
	public static void creatingObserversUsingLambdasTwo() {
		Observable<String> source = Observable.just("Alpha", "Betta", "Gamma", "Delta", "Epsilon");
		source.map(String::length)
			.filter(i -> i >= 5)
			.subscribe((i) -> logger.info("Received: onNext -> {}", i),
						Throwable::getMessage);
	}
	
	public static void creatingObserverUsingLambdasThree() {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		source.map(String::length)
			.filter(i -> i >= 5)
			.subscribe((i) -> logger.info("RECEIVED: onNext -> {}", i));
	}
}