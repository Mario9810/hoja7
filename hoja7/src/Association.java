
import java.util.Map;




public class Association<K extends Comparable<K>,V> implements Map.Entry<K,V>
{


    protected K key; 
  
    protected V value; 

//hace la asociacion de terminos
    public Association(K key, V value)
    {
        assert (key != null);
        key = key;
        value = value;
    }


    public Association(K key)
    {
        this(key,null);
    }

 
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
  
    public V getValue()
    {
        return value;
    }

  
    public K getKey()
    {
        return key;
    }
    public V setValue(V value)
    {
        V oldValue = value;
        value = value;
        return oldValue;
    }

    
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append(" - "+getKey()+": "+getValue()+"\n");
        return s.toString();
    }

    public int compareTo(K key){
        return this.key.compareTo(key);
    }

}