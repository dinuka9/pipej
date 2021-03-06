package tech.dinuka9;

import tech.dinuka9.pipej.Callable;
import tech.dinuka9.pipej.Plugin;

public class MultiplicationPlugin extends Plugin<TestContext> {

    @Override
    public void execute(TestContext testContext, Callable<TestContext> callback) {
        testContext.c = testContext.a * testContext.b * testContext.c;
        callback.onComplete(testContext);
    }
}
