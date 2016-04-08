package com.myclinica.domain;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class RunClinicaTestTestAddClients {

	@Test
	public void testAddClients() {
		RunClinicaTest run = new RunClinicaTest();
		run.addClients();
		assertEquals("Pavel", run.getClients());
	}

}
