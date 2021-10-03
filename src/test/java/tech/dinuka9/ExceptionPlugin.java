package tech.dinuka9;

import tech.dinuka9.pipej.Callable;
import tech.dinuka9.pipej.Plugin;

public class ExceptionPlugin extends Plugin<TestContext> {

    @Override
    public void execute(TestContext testContext, Callable<TestContext> callback) {
        callback.onError("Unexpected Arithmetic Exception !");
    }

}
