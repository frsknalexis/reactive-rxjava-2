package com.dev.rx.java.app.observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class DisposingObservableThree {

	private static final Logger logger = LoggerFactory.getLogger(DisposingObservableThree.class);
	
	public static void main(String...strings) {
		Observable<Integer> source = Observable.create((emitter) -> {
			try {
				for (int i = 0; i < 1000; i++) {
					while (!emitter.isDisposed()) {
						emitter.onNext(i);
						i++;
					}
					if (emitter.isDisposed())
						return;	
				}
				emitter.onComplete();
			} catch(Throwable t) {
				emitter.onError(t);
			}
		});
		
		source.take(5)
			.subscribe((i) -> logger.info("onNext -> {}", i));
	}
}
