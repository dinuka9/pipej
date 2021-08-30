package tech.dinuka9.pipej;

import tech.dinuka9.pipej.model.Context;

public interface Callable<T extends Context> {

    void complete(T t);

}
