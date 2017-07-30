package com.spiraledlogic;

import org.junit.*;

import com.spiraledlogic.web.model.ConwayGameOfLife;



public class ConwayGameOfLifeTest {
	private ConwayGameOfLife cgol;
	private ConwayGameOfLife cgolCopy;
	private ConwayGameOfLife hardCode;
	private ConwayGameOfLife hardCodeAnswer;
	
	@Before
	public void setup() {
		cgol = new ConwayGameOfLife(6,8,.25);
		cgolCopy = new ConwayGameOfLife(cgol);
		Boolean[][] hardCodeMap = {{false,true,false},{true,true,true},{false,false,true}};
		Boolean[][] hardCodeNextGen = {{true,true,true},{true,false,true},{false,false,true}};
		/*
		 *  F T F         T T T
		 *  T T T ----->  T F T
		 *  F F T         F F T
		 */
		hardCode = new ConwayGameOfLife(hardCodeMap,3,3);
		hardCodeAnswer = new ConwayGameOfLife(hardCodeNextGen,3,3);
	}
	
	@Test
	public void constructorInitsHeightCorrectly() {
		int height = cgol.getHeight();
		
		Assert.assertEquals("Height init improperly", 6, height);		
	}
	
	@Test
	public void constructorInitsWidthCorrectly() {
		int width = cgol.getWidth();
		
		Assert.assertEquals("Width init improperly", 8, width);
	}
	
	@Test
	public void constructorReturnsNotNull() {
		Assert.assertNotNull("Woops, uninitialized object",cgol);
	}
	
	@Test
	public void constructorInitMatrix() {
		Boolean[][] matrix = cgol.getGameboard();
		
		Assert.assertNotNull("Woops, uninitialized matrix", matrix);
	}
	@Test
	public void constructorReturnsUnemptyMatrix() {
		Assert.assertNotEquals("Such empty", new String(), cgol.toString());
	}
	
	@Test
	public void overloadConstructorCopiesCorrectly() {
		String original = cgol.toString();
		String copyToString = cgolCopy.toString();
		
		Assert.assertEquals("Copy Malfunction", original, copyToString);
	}
	@Test
	public void generateNextStateGivesCorrectResponse() {
		Boolean[][] response = hardCode.generateNextState();
		ConwayGameOfLife asAGameBoard = new ConwayGameOfLife(response,3,3);
		
		Assert.assertEquals("Not generating expected response", hardCodeAnswer.toString()	, asAGameBoard.toString());
	}
}
