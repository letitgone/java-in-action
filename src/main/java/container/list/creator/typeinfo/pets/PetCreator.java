package container.list.creator.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author ZhangGJ
 * @Date 2020/01/18 07:55
 */
public abstract class PetCreator {

    private Random rand = new Random(47L);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet(){
        int n = this.rand.nextInt(this.types().size());

        try {
            return (Pet)((Class)this.types().get(n)).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];

        for (int i = 0; i < size; i++) {
            result[i] = this.randomPet();
        }

        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, this.createArray(size));
        return result;
    }
}
