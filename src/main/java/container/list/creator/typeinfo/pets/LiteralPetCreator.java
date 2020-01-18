package container.list.creator.typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2020/01/18 07:56
 */
public class LiteralPetCreator extends PetCreator {

    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays
        .asList(Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class,
            EgyptianMau.class, Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class));

    private static final List<Class<? extends Pet>> types;

    static {
        types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
