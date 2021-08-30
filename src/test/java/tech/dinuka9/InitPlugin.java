package tech.dinuka9;

import tech.dinuka9.pipej.Callable;
import tech.dinuka9.pipej.Plugin;

public class InitPlugin extends Plugin<TestContext> {

    @Override
    public void onExecute(TestContext testContext, Callable<TestContext> callback) {
        testContext.a = 5;
        testContext.b = 3;
        callback.complete(testContext);
    }
}
