package io.rahul.example;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class CounterService implements Serializable {

	private static final long serialVersionUID = -7612311756950893728L;
	private AtomicInteger counter = new AtomicInteger();
	private Date date;

	public String getCounter(Date currentTime) {
		String responseString = "The counter Value is: "
		        + counter.getAndIncrement() + " last access time is : "
		        + (date == null ? currentTime : date);
		date = currentTime;
		return responseString;
	}
}
