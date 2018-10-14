package problemSet_1;

public class Demo {

    public static void main(String[] a) throws Exception {
        LRU lru = new LRU(3);
        lru.setNode(1, "Prakash");
        lru.setNode(2, "Manish");
        lru.setNode(3, "Aashish");
        lru.setNode(4, "Abhishek");
        System.out.println(lru.getNode(1).getContent());
    }
}
