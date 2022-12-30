import java.util.*;

/**
 * Этот класс хранит базовое состояние, необходимое для алгоритма A* для вычисления
 * путь по карте. Это состояние включает в себя коллекцию "открытых путевых точек" и
 * другую коллекцию "закрытых путевых точек". Кроме того, этот класс обеспечивает
 * основные операции, необходимые алгоритму поиска пути A* для выполнения его
 * обработки.
 **/
public class AStarState {
    /**
     * Это ссылка на карту, по которой перемещается алгоритм A*.
     * */
    private Map2D map;

    private HashMap<Location, Waypoint> openWaypoint = new HashMap<>();
    private HashMap<Location, Waypoint> closeWaypoint = new HashMap<>();


    /**
     * Инициализируйте новый объект состояния для использования алгоритма поиска пути A*.  **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /**
     * Возвращает карту, по которой перемещается навигатор A*.
     * **/
    public Map2D getMap() {
        return map;
    }
    /**
     *1) Возвращает текущее количество открытых путевых точек.
     **/
    public int numOpenWaypoints() {


        return openWaypoint.size();
    }


    /**
     *2) Этот метод сканирует все открытые путевые точки и возвращает путевую точку
     *  * с минимальной общей стоимостью. Если открытых путевых точек нет, этот метод
     *  * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
        // TODO:  Implement.
        if (openWaypoint.isEmpty()) {
            return null;
        }
        Collection<Waypoint> arrayList = openWaypoint.values();
        double min = Double.MAX_VALUE;
        Waypoint finalWaypoint = null;
        for (Waypoint waypoint : arrayList) {
            if (waypoint.getTotalCost() < min) {
                min = waypoint.getTotalCost();
                finalWaypoint = waypoint;
            }
        }
        return finalWaypoint;
    }

    /***3)
     * Этот метод добавляет путевую точку к (или потенциально обновляет уже имеющуюся путевую точку
     * в) коллекция "открытые путевые точки". Если еще не существует открытого
     * путевая точка в местоположении новой путевой точки, тогда новая путевая точка просто
     * добавлено в коллекцию. Однако, если в
     местоположении * новой путевой точки уже есть путевая точка, новая путевая точка заменяет только старую <em>
     * если</em> значение "предыдущей стоимости" новой путевой точки меньше текущего
     * значение "предыдущей стоимости" путевой точки.  Метод вернет true если точка добавлена
     **/
    public boolean addOpenWaypoint(Waypoint newWP) {
        Location location = newWP.getLocation();
        if (openWaypoint.containsKey(location)) {
            Waypoint waypoint = openWaypoint.get(location);
            if (newWP.getPreviousCost() < waypoint.getPreviousCost()) {
                openWaypoint.put(location, newWP);
                return true;
            }
            return false;
        }
        openWaypoint.put(location, newWP);
        return true;
    }
    /***4)
     *  Возвращает значение true, если коллекция закрытых путевых точек содержит путевую точку
     * для указанного местоположения. Закрытые вершины храняться в хэш-карте
     **/
    public boolean isLocationClosed(Location loc) {
        return closeWaypoint.containsKey(loc);
    }




    /**5)
     * Этот метод перемещает путевую точку в указанном местоположении из
     * открытого списка в закрытый список.
     **/
    public void closeWaypoint(Location loc) {
        /**
        *удалить вершину из открытыъ
         *  * */
        if (openWaypoint.containsKey(loc)){
        closeWaypoint.put(loc, openWaypoint.get(loc));
        /**
         * добавить в закрытые
          */
        openWaypoint.remove(loc);}

    }



}

