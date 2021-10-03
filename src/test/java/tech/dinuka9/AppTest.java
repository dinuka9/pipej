package tech.dinuka9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tech.dinuka9.pipej.Pipeline;
import tech.dinuka9.pipej.exception.PipelineException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    TestContext context = new TestContext();

    InitPlugin initPlugin = new InitPlugin();
    AdditionPlugin additionPlugin = new AdditionPlugin();
    MultiplicationPlugin multiplicationPlugin = new MultiplicationPlugin();
    ExceptionPlugin exceptionPlugin = new ExceptionPlugin();

    Pipeline<TestContext> arithmeticPipeline;

    @BeforeEach
    public void init() {
        arithmeticPipeline = new Pipeline<>();
        arithmeticPipeline.addPlugin(1, initPlugin);
        arithmeticPipeline.addPlugin(2, additionPlugin);
        arithmeticPipeline.addPlugin(3, multiplicationPlugin);
    }

    @DisplayName("General Flow")
    @Test
    public void executeTest() {
        arithmeticPipeline.run(context);

        System.out.println(context.c);

        assertEquals(120, context.c);
    }

    @DisplayName("Error Flow")
    @Test
    public void exceptionTest(){
        assertTrue(
                assertThrows(PipelineException.class, () -> {
                    arithmeticPipeline.addPlugin(4, exceptionPlugin);
                    arithmeticPipeline.run(context);
                }).getMessage().contains("Unexpected Arithmetic Exception !"));

    }
}
