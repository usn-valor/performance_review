package serializable;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human implements Serializable {

    @Serial
    private static final long serialVersionUID = -3722203743604454371L;

    public String name;
    public List<String> assets = new ArrayList<>();

    public Human() {
    }

    public Human(String name, String... assets) {
        this.name = name;
        if (assets != null) {
            this.assets.addAll(Arrays.asList(assets));
        }
    }
}
