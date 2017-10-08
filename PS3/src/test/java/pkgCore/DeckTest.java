package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {
	
	@Test 
	public void TestEmptyDeck() {
		
		Deck d = new Deck();
		int i = 0;
		for (; i<52 ; i++) {
			d.Draw();
		}
		assertNull(d.Draw().geteRank());
		assertNull(d.Draw().geteSuit());
	}
	
	@Test
	public void TestDrawSuit() {
		
		Deck d = new Deck();
		for (int i = 0; i < 13; i++) {
			assertNotNull(d.Draw(pkgEnum.eSuit.SPADES).geteRank());
		}
		assertNull(d.Draw(pkgEnum.eSuit.SPADES).geteSuit());
	}
	
	@Test
	public void TestDrawRank() {
		
		Deck d = new Deck();
		for (int i = 0; i < 4; i++) {
			assertNotNull(d.Draw(pkgEnum.eRank.EIGHT).geteSuit());
		}
		assertNull(d.Draw(pkgEnum.eRank.EIGHT).geteSuit());
	}
	
	@Test
	public void TestDeckRankCount() {
		
		Deck d = new Deck();
		assertEquals(d.nbrOfeRank(pkgEnum.eRank.ACE), 4);
		assertEquals(d.nbrOfeRank(pkgEnum.eRank.TEN), 4);
		d.Draw(pkgEnum.eRank.TEN);
		assertEquals(d.nbrOfeRank(pkgEnum.eRank.TEN), 3);

	}
	@Test
	public void TestDeckSuitCount() {
		//TODO: Build a deck, test the DeckSuitCount method
		Deck d = new Deck();
		assertEquals(d.nbrOfeSuit(pkgEnum.eSuit.CLUBS), 13);
		assertEquals(d.nbrOfeSuit(pkgEnum.eSuit.SPADES), 13);
		d.Draw(pkgEnum.eSuit.SPADES);
		assertEquals(d.nbrOfeSuit(pkgEnum.eSuit.SPADES), 12);
		
	}
	@Test
	public void TestCardCheck() {
		Deck d = new Deck();
		assertEquals(d.cardCheck(pkgEnum.eRank.ACE, pkgEnum.eSuit.SPADES),1);
		for (int i = 0; i<52 ; i++) {
			d.Draw();
		}
		assertEquals(d.cardCheck(pkgEnum.eRank.ACE, pkgEnum.eSuit.SPADES), 0);
		
	}

}
