import org.junit.Assert;
        import org.junit.Test;

public class MainTest {
    @Test
    public void testNumber1() {
        String actRes = Main.number("01-AA-01");
        String expRes = "01AA02";
        Assert.assertEquals(expRes, actRes);
    }
    @Test
    public void testNumber2() {
        String actRes = Main.number("01-AZ-99");
        String expRes = "01BA01";
        Assert.assertEquals(expRes, actRes);
    }
    @Test
    public void testNumber3() {
        String actRes = Main.number("01-ZZ-99");
        String expRes = "02AA01";
        Assert.assertEquals(expRes, actRes);
    }
}