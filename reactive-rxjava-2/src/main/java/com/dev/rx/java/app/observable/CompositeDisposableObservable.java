package com.dev.rx.java.app.observable;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class CompositeDisposableObservable {

	private static final Logger logger = LoggerFactory.getLogger(CompositeDisposableObservable.class);
	
	private static final CompositeDisposable disposables = new CompositeDisposable();
	
	public static void main(String...strings) throws InterruptedException {
		Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
		// subscribe and capture disposables
		Disposable disposable1 = source.subscribe((l) -> logger.info("Observer 1: onNext -> {}", l),
										(e) -> logger.info("onError -> {}", e.getMessage()),
										() -> logger.info("onComplete"));
		Disposable disposable2 = source.subscribe((l) -> logger.info("Observer 2: onNext -> {}", l),
										(e) -> logger.info("onError -> {}", e.getMessage()),
										() -> logger.info("onComplete"));
		disposables.addAll(disposable1, disposable2);
		sleep(5000);
		disposables.dispose();
		sleep(5000);
	}
	
	public static void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
}