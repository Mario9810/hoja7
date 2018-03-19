


public class BinaryTree<K extends Comparable<K>, V> {
    public Node<K,V> root;

    public BinaryTree(){
        this.root = null;
    }

 
 
    public V find(K key){
        Node<K,V> current = root;
        while(current != null){
            int comparation = current.data.compareTo(key);  // Comparar la palabra con la llave de la asociacion en el nodo
            if(comparation == 0){
                return current.data.getValue();
            }else if(comparation > 0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return null;
    }


    public void insert(K key, V value){
        Node<K,V> newNode = new Node<K,V>(key, value);
        if(root==null){
            root = newNode;
            return;
        }

        Node<K,V> current = root;
        Node<K,V> parent = null;
        while(true){
            parent = current;
            int comparation = current.data.compareTo(key);
            if(comparation > 0){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
 
    }
    public void display(Node<K,V> root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data.toString());
            display(root.right);
        }
    }
}


class Node<K extends Comparable<K>,V>{
    Association<K, V> data;
    Node<K,V> left;
    Node<K,V> right;
    public Node(K key, V value){
        this.data = new Association<K, V>(key, value);
        left = null;
        right = null;
    }
}