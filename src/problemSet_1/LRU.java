package problemSet_1;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    private Map<Integer, Node> cacheMap;
    private Node head = null;
    private Node tail = null;
    private int maxVersion;

    public LRU(int maxVersions) {
        this.cacheMap = new HashMap<Integer, Node>(Math.round(maxVersions/0.75f) + 1);
        this.maxVersion = maxVersions;
    }

    public Node getNode(Integer key) throws Exception {
        Node node = this.cacheMap.get(key);
        if(node == null)
            throw new Exception(" Value for given key does not exist in cache ");
        this.addAsHead(node);
        return node;

    }

    public void setNode(Integer key, String content) {
        Node node = this.cacheMap.get(key);
        if(node == null) {
            if(this.cacheMap.size() == maxVersion)
                removeTail();
            Node newNode = new Node(content, key);
            this.cacheMap.put(key, newNode);
            newNode.next = head;
            if(head != null)
                head.previous = newNode;
            head = newNode;
            if(head.next == null)
                tail = head;
            return;
        }

        node.content = content;
        addAsHead(node);
    }

    private void removeTail(){
        Node node = tail.previous;
        node.next = null;
        this.cacheMap.remove(tail.key);
        tail = node;
    }

    private void addAsHead(Node node){
        if (node.previous != null)
            node.previous.next = node.next;
        if(node.next != null)
            node.next.previous = node.previous;
        node.previous = null;
        node.next = head;
        head.previous = node;
        head = node;
    }

/*    public Map<Integer, Node> getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(Map<Integer, Node> cacheMap) {
        this.cacheMap = cacheMap;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }*/

    public static class Node {
        private Node previous;
        private Node next;
        private String content;
        private Integer key;

        public Node(String content, Integer key) {
            this.content = content;
            this.key = key;
        }

        public Node(Node previous, Node next, String content) {
            this.previous = previous;
            this.next = next;
            this.content = content;
        }

/*        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }



        public void setContent(String content) {
            this.content = content;
        }*/

        public String getContent() {
            return content;
        }
    }

}
