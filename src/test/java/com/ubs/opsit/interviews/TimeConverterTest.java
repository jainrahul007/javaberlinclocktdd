package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeConverterTest {

	TimeConverter timeConverter;
	
	@Before
	public void setUp() throws Exception {	
		timeConverter= new TimeConverterImpl() ;
		
	}

	@Test
	public void emptyTime() {
		assertEquals(null, timeConverter.convertTime(null));
	}
	
	@Test
	public void dayStartTime() {
		assertEquals("Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO", timeConverter.convertTime("00:00:00"));
	}
	
	@Test
	public void afterdayStartTime() {
		assertEquals("O\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO", timeConverter.convertTime("00:00:01"));
	}	
	
	@Test
	public void earlyMorningTime() {
		assertEquals("Y\r\nROOO\r\nOOOO\r\nYYRYYOOOOOO\r\nYYOO", timeConverter.convertTime("05:27:08"));
	}
	
	@Test
	public void midDayTime() {
		assertEquals("Y\r\nRROO\r\nRROO\r\nOOOOOOOOOOO\r\nOOOO", timeConverter.convertTime("12:00:00"));
	}	

	@Test
	public void afternoonTime() {
		assertEquals("O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO", timeConverter.convertTime("13:17:01"));
	}
	
	@Test
	public void eveningTime() {
		assertEquals("O\r\nRRRO\r\nRRRR\r\nOOOOOOOOOOO\r\nYOOO", timeConverter.convertTime("19:1:7"));
	}

	@Test
	public void beforeMidNightTime() {
		assertEquals("O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY", timeConverter.convertTime("23:59:59"));
	}
	
	@Test
	public void dayEndTime() {
		assertEquals("Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO", timeConverter.convertTime("24:00:00"));
	}	
}