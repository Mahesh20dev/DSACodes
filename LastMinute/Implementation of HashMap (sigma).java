// Implementation of HashMap (sigma)
import java.util.*;

import org.w3c.dom.Node;
public class OnceAgain {
    static class HashMap<K, V> {     // generic
        // create a Node class
        private class Node {
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;     // size of nodes
        private int N;      // length of array (buckets)
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            // crating array size 4
            
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
                // creating LL node in the array
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;   // data index

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        public void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            // storing bucket elements into oldBuck

            buckets = new LinkedList[N*2];
            // creating new array size double of previous size

            N = N * 2;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for(int i=0; i<oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {         // already present then update the value
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {         // first time, then add new node
                buckets[bi].add(new Node(key, value));
                n++;
            }  
            
            double lambda = (double) n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node: ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("US", 50);
        hm.put("China", 140);

        // ArrayList<String> keys = hm.keySet();
        // for(String key : keys) {
        //     System.out.println(key);
        // }

        // System.out.println(hm.containsKey("US"));
        // hm.remove("China");
        // System.out.println(hm.containsKey("China"));
        // System.out.println(hm.get("India"));
        // System.out.println(hm.isEmpty());

        System.out.println(hm.size());
    }
}