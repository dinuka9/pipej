package tech.dinuka9.pipej;

import tech.dinuka9.pipej.model.Context;

public abstract class Plugin <T extends Context> {

    public abstract void execute(T t, Callable<T> callback);

}
