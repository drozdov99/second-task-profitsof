import org.junit.Assert;
import org.junit.Test;
import ua.profitsoft.trainee.drozdov.task1.StringVowelsSeparatorService;

public class VowelsSeparatorServiceTest {
    @Test
    public void testOneVowel(){
        String expected = "a";
        Assert.assertEquals(expected, StringVowelsSeparatorService.getInstance().interviewRecursionTest("a"));
    }
    @Test
    public void testTwoVowelInRow(){
        String expected = "a*e";
        Assert.assertEquals(expected, StringVowelsSeparatorService.getInstance().interviewRecursionTest("ae"));
    }
    @Test
    public void testVowelAtEndOfWord(){
        String expected = "H*i";
        Assert.assertEquals(expected, StringVowelsSeparatorService.getInstance().interviewRecursionTest("Hi"));
    }
    @Test
    public void testVowelAtBeginningOfWord(){
        String expected = "A*m";
        Assert.assertEquals(expected, StringVowelsSeparatorService.getInstance().interviewRecursionTest("Am"));
    }
    @Test
    public void testVowelAtMiddleOfWord(){
        String expected = "H*i*s";
        Assert.assertEquals(expected, StringVowelsSeparatorService.getInstance().interviewRecursionTest("His"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalLetter(){
        StringVowelsSeparatorService.getInstance().interviewRecursionTest("іфваі");
    }
}
