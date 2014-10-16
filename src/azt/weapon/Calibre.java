package azt.weapon;

/**
 * @author Alexander Vlasov
 */
public class Calibre {
    private final String type;

    public Calibre(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return '"' + type + '"';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calibre calibre = (Calibre) o;

        if (!type.equals(calibre.type)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
