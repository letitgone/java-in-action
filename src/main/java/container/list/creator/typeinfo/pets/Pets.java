package container.list.creator.typeinfo.pets;

import java.util.ArrayList;

/**
 * @Author ZhangGJ
 * @Date 2020/01/18 07:54
 */
public class Pets {

    private static final PetCreator creator = new LiteralPetCreator();

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }

}
