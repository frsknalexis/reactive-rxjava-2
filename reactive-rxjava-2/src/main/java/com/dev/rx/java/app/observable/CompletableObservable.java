package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Completable;

public class CompletableObservable {

	private static final Logger logger = LoggerFactory.getLogger(CompletableObservable.class);
	
	public static void main(String...strings) {
		Completable.fromRunnable(() -> runProcess())
				.subscribe(() -> logger.info("onComplete"),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
	
	public static void runProcess() {
		logger.info("Running some Process");
	}
}
