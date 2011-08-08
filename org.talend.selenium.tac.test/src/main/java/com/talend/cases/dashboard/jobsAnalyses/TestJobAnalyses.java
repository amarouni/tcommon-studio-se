package com.talend.cases.dashboard.jobsAnalyses;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.awt.Event;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestJobAnalyses extends Login {
	@Test
	@Parameters({"Mysql_Connectionlabel"})
	public void testJobAnalyses(String connection) {
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.clickWaitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input");
		this.MouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']");
		this.waitForElementPresent("//img[@title='Ok']", WAIT_TIME);
		//select a connection and simulate a click
		selenium.mouseDown("//img[@title='Ok']/ancestor::table");
		//not less than one "Ok"s are displayed
		this.sleep(10000);
		assertTrue(selenium.getXpathCount("//img[@title='Ok']").intValue() > 1);
		//System.out.println(selenium.getXpathCount("//img[@title='Ok']"));
	}
	
	@Test
	@Parameters({"MSSQL_Connectionlabel"})
	public void testDeleteConnectionUsedByJobAnalyses(String connection) {
		String warningmessage = other.getString("delete.connetion.warning");
		String warningmessage1 =  "Delete Faild: Cannot delete connection "+'"'+connection+'"'+" because it's active for...";
		this.clickWaitForElementPresent("!!!menu.dashjobs.element!!!");
		//wait and select the first "connection"
		this.clickWaitForElementPresent("//label[text()='Active connection:']/following-sibling::div//input");
		this.MouseDownWaitForElementPresent("//div[contains(@class,'x-combo-list-item') and text()=' "+connection+"']");
		this.waitForElementPresent("//img[@title='Ok']", WAIT_TIME);
		//select a connection and simulate a click
		selenium.mouseDown("//img[@title='Ok']/ancestor::table");
		//not less than one "Ok"s are displayed
		this.sleep(5000);
		assertTrue(selenium.getXpathCount("//img[@title='Ok']").intValue() > 1);
		//System.out.println(selenium.getXpathCount("//img[@title='Ok']"));
		this.clickWaitForElementPresent("!!!menu.connections.element!!!");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connection + "')]", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connection + "')]");
		this.sleep(3000);
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//div[text()='Connections']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
		assert (selenium.getConfirmation().equals(warningmessage));
		this.waitForTextPresent(warningmessage1, WAIT_TIME);
		selenium.refresh();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connection + "')]", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		
	}
}