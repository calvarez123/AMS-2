import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap implements Serializable {
    HashMap<String, Integer>  diccionario = new HashMap<>() ;

    public HashMap<String,Integer> getDiccionario() {
        return this.diccionario;
    }

    public void setDiccionario(HashMap<String,Integer> diccionario) {
        this.diccionario = diccionario;
    }

    @Override
    public String toString() {
        return "{" +
            " diccionario='" + getDiccionario() + "'" +
            "}";
    }
    
}
