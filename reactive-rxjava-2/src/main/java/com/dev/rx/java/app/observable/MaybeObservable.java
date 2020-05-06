package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public class MaybeObservable {

	private static final Logger logger = LoggerFactory.getLogger(MaybeObservable.class);
	
	public static void main(String...strings) {
		//has emission
		Maybe<Integer> presentSource = Maybe.just(100);
		presentSource.subscribe((i) -> logger.info("Process 1 received: onNext -> {}", i),
									(e) -> logger.info("onError -> {}", e.getMessage()),
									() -> logger.info("Process 1: onComplete"));
		
		// has no emission
		Maybe<Integer> empytSource = Maybe.empty();
		empytSource.subscribe((i) -> logger.info("Process 2 received: onNext -> {}", i),
								(e) -> logger.info("onError -> {}", e.getMessage()),
								() -> logger.info("Process 2: onComplete"));
		
		logger.info("Maybe Observable using First Element");
		maybeObservableUsingFirstElementOperator();
	}
	
	public static void maybeObservableUsingFirstElementOperator() {
		Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
		source.firstElement()
			.subscribe((s) -> logger.info("Process 3 received: onNext -> {}", s),
						(e) -> logger.info("onError -> {}", e.getMessage()),
						() -> logger.info("Process 3: onComplete"));
	}
}
