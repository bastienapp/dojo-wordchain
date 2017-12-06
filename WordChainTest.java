import junit.framework.*;
import org.junit.Test;
import org.junit.Assert;

public class WordChainTest extends TestCase {

	@Test
	public void testTrue() throws Exception {
		assertEquals(true, true);
	}

	@Test
	public void test1() throws Exception {
		String[] result = {
			"cat",
			"cot",
			"cog",
			"dog"
		};
		WordChain wordchain = new WordChain();
		Assert.assertArrayEquals(result, wordchain.solves("cat", "dog"));
	}

	@Test
	public void test2() throws Exception {
		String[] result = {
			"lead",
			"load",
			"goad",
			"gold"
		};
		WordChain wordchain = new WordChain();
		Assert.assertArrayEquals(result, wordchain.solves("lead", "gold"));
	}

	@Test
	public void test3() throws Exception {
		String[] result = {
			"ruby",
			"rubs",
			"robs",
			"rods",
			"rode",
			"code"
		};
		WordChain wordchain = new WordChain();
		Assert.assertArrayEquals(result, wordchain.solves("ruby", "code"));
	}
}