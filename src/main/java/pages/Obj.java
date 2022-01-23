package pages;

import java.util.HashMap;
import java.util.Objects;

class Obj {

    int id;
    public static int i = 0;

    public Obj(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(id, ((Obj) o).id);
    }

    @Override
    public int hashCode() {
        return i++;
    }

    public static void main(String[] args) {
        HashMap<Obj, String> map = new HashMap<>();
        map.put(new Obj(1), "test");
        String s = map.get(new Obj(1));

        System.out.println(s);
        System.out.println(i);
        System.out.println(new Obj(1).equals(new Obj(1)));
    }
}