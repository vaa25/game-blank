package azt.weapon;

import java.util.Map;
import java.util.TreeMap;

/**
 * Зависимость вероятности попадания по мишени площадью 1 м.кв. от расстояния
 *
 * @author Alexander Vlasov
 */
public class WeaponDiagram {
    private TreeMap<Integer, Double> diagram;

    public WeaponDiagram(TreeMap<Integer, Double> diagram) {
        this.diagram = diagram;
    }

    public void put(int x, double y) {
        diagram.put(x, y);
    }

    /**
     * Берет значение по графику методом линейной интерполяции
     *
     * @param x расстояние
     *
     * @return вероятность попадания без учета дополнительных факторов
     */
    public Double get(int x) {
        Double y = diagram.get(x);
        if (y == null) {
            Map.Entry<Integer, Double> higherEntry = diagram.higherEntry(x);
            Map.Entry<Integer, Double> lowerEntry = diagram.lowerEntry(x);
            if (lowerEntry == null) {
                lowerEntry = diagram.higherEntry(higherEntry.getKey() + 1);
                y = interpolate(x, higherEntry, lowerEntry);
            } else if (higherEntry == null) {
                higherEntry = diagram.lowerEntry(lowerEntry.getKey() - 1);
                y = interpolate(x, higherEntry, lowerEntry);
            } else y = interpolate(x, lowerEntry, higherEntry);
        }
        return y;
    }

    /**
     * Метод находит вторую координату точки путем линейной интерполяции по двум другим точкам
     *
     * @param x           известная координата искомой точки
     * @param lowerEntry  предыдущая точка на графике
     * @param higherEntry следующая точка на графике
     *
     * @return y
     */
    private Double interpolate(int x, Map.Entry<Integer, Double> lowerEntry, Map.Entry<Integer, Double> higherEntry) {
        int x1 = lowerEntry.getKey();
        int x2 = higherEntry.getKey();
        double y1 = lowerEntry.getValue();
        double y2 = higherEntry.getValue();
        double y = (y2 - y1) * (x - x1) / (x2 - x1) + y1;
        return y;
    }

    public int getMissed(int random, double probability) {
        int rest = (int) (random - probability);
        return 10 * rest / 100;
    }

}
