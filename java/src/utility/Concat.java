package utility;

import java.lang.reflect.Array;

public class Concat {

    public static <T> T concat(T... ts){
        int lenght=0;
        for(T obj:ts){
            lenght += Array.getLength(obj);
        }
        T arr=(T)Array.newInstance(ts.getClass().getComponentType().getComponentType(),lenght);
        int indx=0;
        for(T obj:ts){
            System.arraycopy(obj,0,arr,indx,Array.getLength(obj));
            indx+=Array.getLength(obj);
        }
        return arr;
    }
}
