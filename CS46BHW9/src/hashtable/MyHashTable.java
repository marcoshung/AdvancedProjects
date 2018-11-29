package hashtable;
import java.util.ArrayList; 

// Class to represent entire hash table 
class MyHashTable<K, V>
{ 
    // bucketArray is used to store array of chains 
    //TODO
  ArrayList<HashNode<K,V>> bucketArray;
  
    // Current capacity of array list 
    //TODO
  	int numBuckets;
  
  
    // Current size of array list 
    //TODO
    int size;
    
    
  
    // Constructor (Initializes capacity, size and 
    // empty chains. 
    public MyHashTable() { 
        //TODO
        bucketArray = new ArrayList<HashNode<K,V>>();
        for(int i = 0; i < 10; i++) {
        	bucketArray.add(null);
        }
        size = size();
        numBuckets = 10;
    } 
  
    // Implement the size() method
    public int size() {
    	return this.size;
    }
        
   //Implement the isEmpty() method
 
   public boolean isEmpty(){
	   return this.size == 0;
   }
      
    // This implements hash function to find index for a key.
    // Do not change this method
    private int getBucketIndex(K key) { 
        int hashCode = key.hashCode(); 
        int index = hashCode % numBuckets; 
        return index; 
    } 
         
    // Implement remove() method
    // Apply hash function to find index for given key
    // Get head of chain 
    // Search for key in its chain. If Key found remove the node and return the 
    // value of the node. If key not found return null.
    public V remove(K key) 
    { 
    	HashNode<K,V> node = bucketArray.get(getBucketIndex(key));
    	HashNode<K,V> prev = null;
    	while(node != null) {
    		if(node.key.equals(key)) {
    			break;    	
    		}
    		prev = node;
    		node = node.next;
    	}
    	if(node == null) {
    		return null;
    	}
    	
    	if(prev != null) {
    		prev.next =  node.next;
    	}else {
    		bucketArray.set(getBucketIndex(key), node.next);
    	}
    	size--;
    	return node.value;
    } 
    
  
    // Implement get() method 
    // Find head of chain for given key
    // Search key in chain. If key found return the value. If not found return null.
    public V get(K key) 
    { 
       //TODO 
        HashNode<K,V> node = bucketArray.get(getBucketIndex(key));
        while(node.next != null) {
        	if(node.key.equals(key)) {
        		return node.value;
        	}
        	node = node.next;
        }
        return null;
    } 
  
    // Implement add() method
    // Find head of chain for given key 
    // Check if key is already present. If true replace the old value with the new value.
    // If false add the new node to the chain and increase the size.
    
    public void add(K key, V value) 
    { 
        //TODo
    	int index = getBucketIndex(key);
    	HashNode<K,V> node = bucketArray.get(index);
    	while(node != null) {
    		if(node.key.equals(key)) {
    			node.value = value;
    			return;
    		}
    		node = node.next;
    	}
    	size++;
    	node = bucketArray.get(index);
    	HashNode<K,V> addition = new HashNode<K,V> (key, value);
    	addition.next = node;
    	bucketArray.set(index, addition);
    } 
}