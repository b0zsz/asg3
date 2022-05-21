public class MyHashTable <K,V>
{
    private class HashNode<K,V>
    {
        private K key;
        private V val;
        private HashNode<K,V> next;
        public HashNode(K key, V val)
        {
            this.key = key;
            this.val = val;
        }
        @override
        public String toString()
        {
            return "{" + key + " " + val + '}';
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable()
    {
        this(M);
    }
    public MyHashTable(int M)
    {
        this.M = size;
        chainArray = new HashNode[M];
        this.size = 0;
    }
    private int hash(K key)
    {
        return key.toString().length() % chainArray.length;
    }

    public void put(K key, V val)
    {
        int hashKey = hash(key);
        HashNode main = chainArray[hashKey];
        HashNode newNumb = new HashNode(key,val);
        newNumb.next = main.next;
        main.next = newNumb;
    }

    public V get(K key)
    {
        int hashKey = hash(key);
        HashNode main = chainArray[hashKey];
        while(main != null)
        {
            if(main.key == key)
            {
                System.out.println(main.val);
            }
            main = main.next;
        }
        return null;
    }

    public V remove(K key)
    {
        int hashKey = hash(key);
        HashNode main = chainArray[hashKey];
        HashNode last = null;
        while(main!= null)
        {
            if(main.key == key)
            {
                break;
            }
            last = main;
            main = main.next;
        }
        if(main == null)
        {
            return null;
        }
        size--;
        if(last!= null)
        {
            last.next = main.next;
        }
        else{
            chainArray[hashKey] = main.next;
        }
        return (V) main.val;
    }

    public boolean contains(V val)
    {
        return contains(val);
    }

    public void getKey(V val)
    {
        int hashedVal = hash((K) val);
        HashNode main = chainArray[hashedVal];
        while(main != null){
            if(main.val == val)
            {
                System.out.println(main.key);
            }
            main = main.next;
        }
    }
}


