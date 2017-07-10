package be.steformations.java_data.timesheets.dao.test;

import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.laura.java_data.timesheets.service.TimesheetsDataServiceJpa;

public class TestsFactory {
		
	public static TimesheetsDataService createTimesheetsDataService() {
		//return new TimesheetsDataServiceImpl();
		return new TimesheetsDataServiceJpa();
	}
}
