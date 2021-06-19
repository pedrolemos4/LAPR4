package base.daemon.executor.algorithms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExecutorController {

    private static List<String> listExecutores;
    private static Map<String, Integer> mapExecutor = new LinkedHashMap<>();

    public ExecutorController(List<String> listServidores) {
        this.listExecutores = listServidores;
        preencherMap(mapExecutor);
    }

    public void preencherMap(Map<String, Integer> mapExecutor) {
        for(String ip : listExecutores){
            mapExecutor.put(ip, 0);
        }
    }

    public static synchronized void addAtividade(String executor){
        mapExecutor.replace(executor, mapExecutor.get(executor) + 1);
    }

    public static synchronized void removeAtividade(String executor){
        mapExecutor.replace(executor, mapExecutor.get(executor) - 1);
    }

    public static Map<String, Integer> getMapa(){
        return mapExecutor;
    }

    public static List<String> getListExecutores(){
        return listExecutores;
    }

}