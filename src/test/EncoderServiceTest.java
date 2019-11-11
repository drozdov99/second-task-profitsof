import org.junit.Assert;
import org.junit.Test;
import ua.profitsoft.trainee.drozdov.task2.StringBinaryEncoderService;

public class EncoderServiceTest {
    @Test
    public void testOneLetterEncode(){
        final String expected = "00 0 0 00 00 0000 0 0";
        Assert.assertEquals(expected,StringBinaryEncoderService.getInstance().encodeMessage("a"));
    }
    @Test
    public void testLetterLetterEncode(){
        final String expected = "00 0 0 00 00 0000 0 0 00 0 0 00 00 000 0 0 00 0";
        Assert.assertEquals(expected,StringBinaryEncoderService.getInstance().encodeMessage("ab"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument(){
        String line = "qwertyuiopasdfghjklzxcvbnmqwertyuiopqwertyuioasdfghjklzxcvbnmqqwertyuioasdfghjklzxcvbnmasdfghjklqwertyuio";
        StringBinaryEncoderService.getInstance().encodeMessage(line);
    }
}
