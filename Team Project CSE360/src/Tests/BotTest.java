package diceGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class BotTest {

	@Test
	public void testBot() {
		Bot test = new Bot(0);
		assertNotNull(test);			
	}
	
	@Test 
	public void testgetType(){
		Bot test = new Bot(0);
		assertEquals(test.getType(),0);
	}
	
	@Test
	public void testgetAction(){
		Bot test = new Bot(0); //Action is set to 0 by default
		assertEquals(test.getAction(),0);
	}
	public void testchooseAction(){
		Bot test1 = new Bot(-1);
		Bot test2 = new Bot(0);
		Bot test3 = new Bot(1);
		
		test1.chooseAction();//should set Action to 0
		test2.chooseAction();//should set Action to -1
		test3.chooseAction();//should set Action to 1
		
		assertEquals(test1.getAction(),0);
		assertEquals(test2.getAction(),-1);
		assertEquals(test3.getAction(),1);
		
	}

}
