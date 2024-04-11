package Data_Structures.HashTables.HashTables_implementation;


import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<K,V> {
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    private static final int DEFAULT_CAPACITY = 16;
    public ArrayList<LinkedList<Entry<K,V>>> buckets;
    private int size;

    public HashTable(){
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity){
        buckets = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++){
            buckets.add(new LinkedList<>());
        }
        size = 0;
    }

    public void put(K key, V value){
        int address = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(address);
    
        for (Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;

        if((double) size / buckets.size() > LOAD_FACTOR_THRESHOLD){
            rehash();
        }
    }

    public V get(K key){
        int address = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(address);
        for(Entry<K,V> entry : bucket){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int address = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(address);
        for(Entry<K,V> entry : bucket){
            if(entry.key.equals(key)){
               bucket.remove(entry);
               size--;
               return;
            }
        }
    }

    public int size(){
        return size;
    }

    private int hash(K key) {
        String stringKey = key.toString();
        int hash = 0;

        for (int i = 0; i < stringKey.length(); i++) {
            hash += stringKey.charAt(i) * i;
        }

        return hash % buckets.size();
    }

    private static class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private void rehash() {
        int newCapacity = buckets.size() * 2;
        ArrayList<LinkedList<Entry<K, V>>> newBuckets = new ArrayList<>(newCapacity);
        for (int i = 0; i < newCapacity; i++) {
            newBuckets.add(new LinkedList<>());
        }

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                int address = hash(entry.key);
                newBuckets.get(address).add(entry);
            }
        }

        buckets = newBuckets;
    }
}
