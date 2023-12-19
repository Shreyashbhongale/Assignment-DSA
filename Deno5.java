
class Deno5 {
    public static void main(String[] args) {
        LinkedList<Integer> x = new LinkedList<>();
        x.add(10);
        x.add(20);
        x.add(30);
        x.add(40);
        x.add(50);

        System.out.println(x);      //10,20,30,40
       // int m = x.max();              //10,20,50,30,40
       // System.out.println(m);
        x.delete(50);
        System.out.println(x);          //10,20,30,40
        x.delete(10);
       // System.out.println(x);          //20,30,40
        x.addBeg(15);
        System.out.println(x);             //15,20,30,40
        x.addBeg(5);
        System.out.println(x);              //5,15,20,30,40

        int n = x.count();
        System.out.println("no of count = "+ n);        //5

        x.insertAt(25,4);
        System.out.println(x);              //5,15,20,25,30,40
        x.insertAt(2,1);
        System.out.println(x);                  //2,5,15,20,25,30,40
        x.deleteAt(3);
        System.out.println(x);                  //2,5,20,25,30,40
        x.deleteAt(1);                          
        System.out.println(x);                      //5,20,25,30,40
         x.insertOrder(27);
        System.out.println(x);                      //5,20,25,27,30,40
        x.insertOrder(35);
        System.out.println(x);                      //5,20,25,27,30,35,40
        x.insertOrder(3);
        System.out.println(x);                   //3,5,20,25,27,30,35,40
    }
}
//-------

class LinkedList<T extends Comparable<T>> {
        Node<T> first;
        void add(T d) {
            Node<T> p = new Node<>(d);
            if (first == null) {
                first = p;
            } else {
                Node<T> c = first;
                while (c.getNext() != null) {
                    c = c.getNext();
                }
                c.setNext(p);
            }
        }

        void delete(T e) {
            if (first == null) {
                return;
            } if (first.getData().equals(e)) {
                first=first.getNext();
                return;
            }
            Node<T> c = first;
            while (c.getNext() != null && !c.getNext().getData().equals(e)) {
                c = c.getNext();
            } if (c.getNext() != null) {
                c.setNext(c.getNext().getNext());
            }
        }

        void addBeg(T d) {
            Node<T> p = new Node<>(d);
            p.setNext(first);
            first=p;
        }

        int count() {
            int count = 0;
            Node<T> c = first;
            while (c != null) {
                count++; 
                c=c.getNext();
            }
            return count;
        }

        void insertAt(T d, int f) {
           
            Node<T> p = new Node<>(d);
            if (f == 1) {
                p.setNext(first);
                first = p;
                return;
            }
            Node<T> c = first;
            for (int i = 1; i < f-1;i++) {
                c = c.getNext();
            }
            p.setNext(c.getNext());
            c.setNext(p);
        }

        void deleteAt(int f) {
            
            if (f == 1) {
                first = first.getNext();
                return;
            }
            Node<T> c = first;
            for (int i = 1; i < f-1;i++) {
                c =c.getNext();
            }
            c.setNext(c.getNext());
        }

        void insertOrder(T d) {
            Node<T> p = new Node<>(d);
            if (first == null || d.compareTo(first.getData()) < 0) {
                p.setNext(first);
                first = p;
                return;
            }
            Node<T> c = first;
            while(c.getNext() != null && d.compareTo(c.getNext().getData()) > 0) {
                c =c.getNext();
            }
            p.setNext(c.getNext());
            c.setNext(p);
        }


        public String toString() {
            String r=" ";
            Node<T> c = first;
            while (c != null) {
              r +=  c.getData();
               if (c.getNext() != null) {
                r += " ";
               }
                c= c.getNext();
            }
            r += " ";
            return r+" ";
            }


            
}


//------------------


class Node<T> {
    T data;
    Node<T> next;
    Node() {
    }
    Node(T d) {
        data = d;
    }
    void setNext(Node <T> nextNode) {
        next = nextNode;
    }
    Node<T> getNext() {
        return next;
    }
    T getData() {
        return data;
    }
    public String toString() {
        return data+" ";
    }
}