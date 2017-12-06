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
		String[] wordchain = {
			"cat",
			"cot",
			"cog",
			"dog"
		};
		Assert.assertArrayEquals(wordchain, WordChain.solves("cat", "dog"));
	}

	@Test
	public void test2() throws Exception {
		String[] wordchain = {
			"lead",
			"load",
			"goad",
			"gold"
		};
		Assert.assertArrayEquals(wordchain, WordChain.solves("lead", "gold"));
	}

	@Test
	public void test3() throws Exception {
		String[] wordchain = {
			"ruby",
			"rubs",
			"robs",
			"rods",
			"rode",
			"code"
		};
		Assert.assertArrayEquals(wordchain, WordChain.solves("lead", "code"));
	}
}