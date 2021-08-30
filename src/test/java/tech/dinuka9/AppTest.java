package tech.dinuka9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tech.dinuka9.pipej.Pipeline;

/**
 * Unit test for simple App.
 */
public class AppTest {

    TestContext context = new TestContext();

    InitPlugin initPlugin = new InitPlugin();
    AdditionPlugin additionPlugin = new AdditionPlugin();
    MultiplicationPlugin multiplicationPlugin = new MultiplicationPlugin();

    Pipeline<TestContext> arithmeticPipeline = new Pipeline<>();

    @Before
    public void init() {
        arithmeticPipeline.addPlugin(1, initPlugin);
        arithmeticPipeline.addPlugin(2, additionPlugin);
        arithmeticPipeline.addPlugin(3, multiplicationPlugin);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void executeTest() {
        arithmeticPipeline.run(context);

        System.out.println(context.c);

        Assert.assertEquals(120, context.c);
    }
}
