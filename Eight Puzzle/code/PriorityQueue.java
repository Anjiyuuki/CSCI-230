
public class PriorityQueue extends Queue {

    public PriorityQueue() {
        super();
    }

    public void priorityEnqueue(Comparable<Object> item) {
        enqueue(item);
    }

	@SuppressWarnings("unchecked")
    public Comparable<Object> priorityDequeue() {
        Comparable<Object> res= (Comparable<Object>) front();
        Stack stack=new Stack();
        while (!isEmpty()){
            if(res.compareTo(front())>0){
                res= (Comparable<Object>) front();
            }
            stack.push(dequeue());
        }

        while (!stack.isEmpty()){
            if(res.compareTo(stack.top())==0){
               stack.pop();
            }else{
                enqueue(stack.pop());
            }
        }

        return res;
    }

}
