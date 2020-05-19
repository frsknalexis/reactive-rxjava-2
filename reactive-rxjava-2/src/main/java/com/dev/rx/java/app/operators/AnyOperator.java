package com.dev.rx.java.app.operators;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class AnyOperator {

	private static final Logger logger = LoggerFactory.getLogger(AnyOperator.class);
	
	public static void main(String...strings) {
		Observable.just("2016-01-01", "2016-05-02", "2016-09-12", "2016-04-03")
				.map((s) -> LocalDate.parse(s))
				.any((dt) -> dt.getMonthValue() >= 6)
				.subscribe((v) -> logger.info("Received: onNext -> {}", v),
							(e) -> logger.info("onError -> {}", e.getMessage()));
	}
}