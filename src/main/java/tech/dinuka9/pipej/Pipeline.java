package tech.dinuka9.pipej;

import tech.dinuka9.pipej.model.Context;

import java.util.*;

public class Pipeline<T extends Context> implements Callable<T> {

    private Map<Integer, Plugin<T>> plugins = new LinkedHashMap<>();

    private Iterator<Map.Entry<Integer, Plugin<T>>> pluginIterator;

    public void run(T context){
        pluginIterator = plugins.entrySet().iterator();
        Optional<Plugin<T>> next = next();
        next.ifPresent(plugin -> plugin.onExecute(context, this));
    }

    @Override
    public void complete(T t) {
        Optional<Plugin<T>> next = next();
        next.ifPresent(plugin -> plugin.onExecute(t, this));
    }

    public void setPlugins(Map<Integer, Plugin<T>> plugins) {
        this.plugins = plugins;
    }

    public void addPlugin(int index, Plugin<T> plugin){
        plugins.put(index, plugin);
    }

    private Optional<Plugin<T>> next(){
        return pluginIterator.hasNext() ? Optional.of(pluginIterator.next().getValue()) : Optional.empty();
    }

}
