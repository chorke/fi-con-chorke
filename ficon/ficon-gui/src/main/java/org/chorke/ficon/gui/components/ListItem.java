
package org.chorke.ficon.gui.components;

/**
 *
 * @author Chorke
 */
public final class ListItem<K, V> {

    private K key;
    private V value;

    public ListItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value == null ? "null" : value.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ListItem)){
            return false;
        }
        ListItem o = (ListItem)obj;
        return equalsNullableObjects(key, o.key) && equalsNullableObjects(value, o.value);
    }
    
    @SuppressWarnings("null")
    private boolean equalsNullableObjects(Object o1, Object o2){
        if((o1 == null && o2 != null)
                || (o1 != null && o2 == null)){
            return false;
        }
        if(o1 == null && o2 == null){
            return true;
        }
        return o1.equals(o2);
    }
}
