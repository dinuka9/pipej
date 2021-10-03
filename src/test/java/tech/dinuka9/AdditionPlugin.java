package tech.dinuka9;

import tech.dinuka9.pipej.Callable;
import tech.dinuka9.pipej.Plugin;

public class AdditionPlugin extends Plugin<TestContext> {

    @Override
    public void execute(TestContext testContext, Callable<TestContext> callback) {
        testContext.c = testContext.a + testContext.b;
        callback.onComplete(testContext);
    }
}
