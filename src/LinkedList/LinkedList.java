package LinkedList;

public class LinkedList {

        private Node first;
        private Node last;
        private int length;

        public LinkedList(){
            this.first=null;
            this.last=null;
            this.length=0;
        }

        //addLast
        public void addLast(int item) {
            Node node = new Node(item);

            if(first==null){
                first=last=node;
            } else {
                last.setNext(node);
                last=node;
            }
            this.length++;
        }

        //addFirst
        public void addFirst(int item){
            Node current = new Node(item);
            if(first==null){
                first=last=current;
            } else {
                current.setNext(first);
                first = current;
            }
            this.length++;
        }

        //indexOf
        public int indexOf(int item){
            int index=0;
            Node current = first;
            while (current!=null){
                if (current.getValue()==item) {
                    return index;
                }
                index++;
                current = current.getNext();
            }
            return -1;
        }

        //contains
        public boolean contains(int item){
            return indexOf(item)!=-1;
        }

        //deleteFirst
        public void deleteFirst(int item){
            if (first==null) return;
            if (first==last){
                first=last=null;
                return;
            }
            Node current = first.getNext();
            first.setNext(null);
            first = current;
            this.length--;
        }
        //deleteLast

        public void deleteLast(int item){
            if (first==null) return;
            if (first==last){
                first = last = null;
            } else {
                Node current = first;
                while (current.getNext().getNext()!=null){
                    current = current.getNext();
                }
                current.setNext(null);
                last = current;
            }
            this.length--;
        }

        //getPrevious
        public Node getPrevious(Node item){
            if (first==null || first==last || !contains(item.getValue())) return null;
            if (first.getNext() == item) return first;
            Node previous = first.getNext();
            Node current = previous.getNext();
            while (current!=null){
                if (current == item) {
                    return previous;
                }
                previous = current;
                current = current.getNext();
            }

            return null;
        }

        public Node getFirst(){return this.first;}
        public Node getLast(){return this.last;}

        public int getLength(){ return  this.length; }

        public String toString(){
            Node current = this.first;
            String result = "[ ";
            while (current!=null){
                result+=current.getValue();
                current=current.getNext();
                if (current!=null){
                    result+=", ";
                }
            }
            result+=" ]";
            return result;
        }
}
