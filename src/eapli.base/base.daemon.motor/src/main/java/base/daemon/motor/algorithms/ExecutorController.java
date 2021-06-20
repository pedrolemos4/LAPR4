package base.daemon.motor.algorithms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExecutorController {

    private static List<String> listExecutores;
    private static Map<String, Integer> mapExecutor = new LinkedHashMap<>();

    public ExecutorController(List<String> listServidores) {
        this.listExecutores = listServidores;
        preencherMap(mapExecutor);
        for(Map.Entry<String, Integer> map: mapExecutor.entrySet()){
            System.out.println("map.getKey:: " + map.getKey());
            System.out.println("map.getValue:: " + map.getValue());
        }
    }

    public void preencherMap(Map<String, Integer> mapExecutor) {
mapExecutor.put("10.8.0.80", 5);
mapExecutor.put("10.8.0.81", 0);        
/*for(String ip : listExecutores){
            mapExecutor.put(ip, 0);
        }*/
    }

    public static synchronized void addAtividade(String executor){
        mapExecutor.replace(executor, mapExecutor.get(executor) + 1);
        System.out.println("MAPA DEPOIS:: " +executor+ "VALUE:: " +mapExecutor.get(executor));

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
