package com.dev.rx.java.app.operators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class MapOperator {

	private static final Logger logger = LoggerFactory.getLogger(MapOperator.class);
	
	public static void main(String...strings) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
		Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
				.map((s) -> LocalDate.parse(s, dtf))
				.subscribe((d) -> logger.info("Received: onNext -> {}", d),
							(e) -> logger.info("onError -> {}", e.getMessage()),
							() -> logger.info("onComplete"));
	}
}
