package container.list.creator.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2020/01/18 09:08
 */
public class FornameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList();

    private static String[] typeNames =
        new String[] {"typeinfo.pets.Mutt", "typeinfo.pets.Pug", "typeinfo.pets.EgyptianMau",
            "typeinfo.pets.Manx", "typeinfo.pets.Cymric", "typeinfo.pets.Rat",
            "typeinfo.pets.Mouse", "typeinfo.pets.Hamster"};

    static {
        loader();
    }

    private static void loader() {
        try {
            String[] var3;
            int var2 = (var3 = typeNames).length;
            for (int var1 = 0; var1 < var2; ++var1) {
                String name = var3[var1];
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
