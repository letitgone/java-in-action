package container.list.creator.typeinfo.pets;

/**
 * @Author ZhangGJ
 * @Date 2020/01/18 08:11
 */
public class Individual implements Comparable<Individual> {

    private static long counter = 0L;

    private final long id;

    private String name;

    public Individual(String name) {
        this.id = (long) counter++;
        this.name = name;
    }

    public Individual() {
        this.id = (long) counter++;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + (this.name == null ? "" : " " + this.name);
    }

    public long id() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Individual && this.id == ((Individual) o).id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (this.name != null) {
            result = 37 * result + this.name.hashCode();
        }
        result = 37 * result + (int) this.id;
        return result;
    }

    @Override
    public int compareTo(Individual arg) {
        String first = this.getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) {
            return firstCompare;
        } else {
            if (this.name != null && arg.name != null) {
                int secondCompare = this.name.compareTo(arg.name);
                if (secondCompare != 0) {
                    return secondCompare;
                }
            }
            return arg.id < this.id ? -1 : (arg.id == this.id ? 0 : 1);
        }
    }
}
