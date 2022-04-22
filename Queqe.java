public class Queqe {
    Node front;
    Node rear;
    
    public void enqueue(String s){
        if( front == null && rear == null ){
            Node node = new Node(  s );
            this.front = node;
            this.rear = node;
        } else {
            Node node = new Node( s , null , this.rear );
            this.rear.nextNode = node;
            this.rear = node;
        }
    }

    public String dequeue(){
        String vv = this.front.value;

        this.front = this.front.nextNode;

        this.front.prevNode = null;

        return vv;
    }

    public Node getFront(){
        return this.front;
    }

    public Node getRear(){
        return this.rear;
    }
}
class Node {
    String value;
    Node prevNode;
    Node nextNode;

    public Node( String v){
        this.value = v;
    }

    public Node( String v , Node nxtNode , Node preNode){
        this.value = v;
        this.nextNode = nxtNode;
        this.prevNode = preNode;
    }
}
