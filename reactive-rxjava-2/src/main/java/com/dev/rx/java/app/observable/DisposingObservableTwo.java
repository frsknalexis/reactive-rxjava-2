package com.dev.rx.java.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

public class DisposingObservableTwo {

	private static final Logger logger = LoggerFactory.getLogger(DisposingObservableTwo.class);
	
	public static void main(String...strings) throws InterruptedException {
		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
		ResourceObserver<Long> myObserver = new ResourceObserver<Long>() {
			
			@Override
			public void onNext(Long t) {
				logger.info("onNext -> {}", t);
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
		
		Disposable disposable = source.subscribeWith(myObserver);
		sleep(5000);
		disposable.dispose();
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}
