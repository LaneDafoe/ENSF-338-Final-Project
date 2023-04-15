package src.main.java.mylib;

import src.main.java.mylib.datastructures.linear.*;
import src.main.java.mylib.datastructures.nodes.*;
import src.main.java.mylib.datastructures.trees.*;
import src.main.java.mylib.datastructures.heap.*;
import src.main.java.mylib.graphalgo.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class App {
    
    public static void main(String[] args) {
        
            /* Linear Testing ----------------------------------------------------- */
            
            
            
            
            
            //doublyCLL Test -----------------------------------------------------
            
            
            CircularDoublyLinkedList list_DCLL = new CircularDoublyLinkedList();
            
            // Add some nodes to the list
            list_DCLL.InsertHead(new DLLNode(1));
            list_DCLL.InsertTail(new DLLNode(2));
            list_DCLL.Insert(new DLLNode(3), 2);
            list_DCLL.SortedInsert(new DLLNode(0));
            
            // Print the list to see if it worked
            list_DCLL.Print();
            
            // Test deleting a node
            DLLNode node = list_DCLL.Search(new DLLNode(2));
            list_DCLL.Delete(node);
            list_DCLL.Print();
            
            // Clear the list
            list_DCLL.Clear();
            list_DCLL.Print();
            
            
            //DoublyLL Test -----------------------------------------------------
            
            
            // Create a new linked list
            DoublyLinkedList list_DLL = new DoublyLinkedList();

            // Insert some nodes
            DLLNode node1_DLL = new DLLNode(1);
            DLLNode node2_DLL = new DLLNode(2);
            DLLNode node3_DLL = new DLLNode(3);
            list_DLL.InsertHead(node1_DLL);
            list_DLL.InsertTail(node2_DLL);
            list_DLL.Insert(node3_DLL, 2);

            // Print the list
            list_DLL.Print();

            // Search for a node
            DLLNode searchNode = new DLLNode(2);
            DLLNode foundNode = list_DLL.Search(searchNode);
            System.out.println("Found node: " + foundNode);

            // Delete a node
            list_DLL.Delete(node1_DLL);
            list_DLL.Print();

            // Clear the list
            list_DLL.Clear();
            list_DLL.Print();
            
            
            //LLQueue Test -----------------------------------------------------
            
            
            Queue queue = new Queue();
            SLLNode node1 = new SLLNode(1);
            SLLNode node2 = new SLLNode(2);
            SLLNode node3 = new SLLNode(3);
            queue.Enque(node1);
            queue.Enque(node2);
            queue.Enque(node3);
            queue.Print();
            int dequeuedValue = queue.Deque();
            System.out.println("Dequeued value: " + dequeuedValue);
            queue.Print();
            
            
            //LLStack Test -----------------------------------------------------
            
            
            Stack stack = new Stack();
            SLLNode node1_stack = new SLLNode(1);
            SLLNode node2_stack = new SLLNode(2);
            SLLNode node3_stack = new SLLNode(3);
            
            // push nodes onto the stack
            stack.push(node1_stack);
            stack.push(node2_stack);
            stack.push(node3_stack);
            
            // peek at the top node
            System.out.println("Peek: " + stack.peek().getValue());
            
            // pop nodes from the stack
            System.out.println("Pop: " + stack.pop().getValue());
            System.out.println("Pop: " + stack.pop().getValue());
            System.out.println("Pop: " + stack.pop().getValue());
            
            
            //singlyCLL Test -----------------------------------------------------
            
            
            // Create a new circular linked list
            CircularLinkedList list_SCLL = new CircularLinkedList();

            // Insert nodes at the head and tail of the list
            list_SCLL.InsertHead(new SLLNode(1));
            list_SCLL.InsertTail(new SLLNode(2));

            // Insert a node at a specific position in the list
            list_SCLL.Insert(new SLLNode(3), 2);

            // Search for a node in the list
            SLLNode searchNode_SCLL = new SLLNode(2);
            SLLNode result = list_SCLL.Search(searchNode_SCLL);
            if (result != null) {
                System.out.println("Node " + result.getValue() + " found in the list");
            } else {
                System.out.println("Node " + searchNode_SCLL.getValue() + " not found in the list");
            }

            // Delete nodes from the list
            list_SCLL.DeleteTail();
            list_SCLL.Delete(new SLLNode(1));

            // Print the list
            list_SCLL.Print();
            
            
            //singlyLL Test -----------------------------------------------------
            
            
            SinglyLinkedList list_SLL = new SinglyLinkedList();
            SLLNode node1_SLL = new SLLNode(1);
            SLLNode node2_SLL = new SLLNode(2);
            SLLNode node3_SLL = new SLLNode(3);
            SLLNode node4_SLL = new SLLNode(4);

            list_SLL.InsertHead(node1_SLL);
            list_SLL.InsertTail(node2_SLL);
            list_SLL.Insert(node3_SLL, 2);
            list_SLL.Delete(node1_SLL);

            list_SLL.Print();
            
            
            /* Nodes Testing ----------------------------------------------------- */
            
            
            

            
            //DLL Node Test -----------------------------------------------------
            
            
            DLLNode node1_doubly = new DLLNode(5);
            DLLNode node2_doubly = new DLLNode(10);
            DLLNode node3_doubly = new DLLNode(15);

            node1_doubly.getNext();
            node2_doubly.getPrev();
            node2_doubly.setNext(node3_doubly);
            node3_doubly.setPrev(node2_doubly);

            System.out.println("node1 value: " + node1.getValue());
            System.out.println("node1 next value: " + node1_doubly.getNext().getValue());
            System.out.println("node2 prev value: " + node2_doubly.getPrev().getValue());
            System.out.println("node2 next value: " + node2_doubly.getNext().getValue());
            System.out.println("node3 prev value: " + node3_doubly.getPrev().getValue());
            
            
            //SLL Node Test -----------------------------------------------------
            
            
            // create a node with value 5
            SLLNode node_singly = new SLLNode(5);

            // test getValue()
            assert node_singly.getValue() == 5;

            // test setNext()
            SLLNode nextNode = new SLLNode(10);
            node_singly.setNext(nextNode);
            assert node_singly.getNext() == nextNode;

            // test setValue()
            node_singly.setValue(7);
            assert node_singly.getValue() == 7;
            

            //Tree Node Test -----------------------------------------------------


            TreeNode parent = new TreeNode(5, 0, null, null, null);
            TreeNode left = new TreeNode(3, 0, parent, null, null);
            TreeNode right = new TreeNode(8, 0, parent, null, null);
            parent.setLeft(left);
            parent.setRight(right);
            
            System.out.println(parent.toString());
            System.out.println(left.toString());
            System.out.println(right.toString());
            
            left.setData(4);
            System.out.println(left.toString());



            /*Trees Testing -------------------------------------------------------------------------------------------- */

            //AVL Testing


            AVL tree = new AVL();
            tree.insert(5);
            tree.insert(10);
            tree.insert(3);
            tree.insert(4);
            tree.insert(7);

            TreeNode root = tree.getRoot();
            System.out.println("Root data: " + root.getData());
            System.out.println("Root balance factor: " + root.getBalance());

            System.out.println("In-order traversal:");
            tree.printInOrder();

            System.out.println("Balance factor traversal:");
            tree.printBF();

            //BST Testing ----------------------------------------------------------------------------------------


            BinarySearchTree bst = new BinarySearchTree();
            // Insert nodes
            bst.Insert(5);
            bst.Insert(3);
            bst.Insert(7);
            bst.Insert(2);
            bst.Insert(4);
            bst.Insert(6);
            bst.Insert(8);
            // Traverse and print nodes in-order
            System.out.println("In-order traversal:");
            bst.traverseInOrder(bst.getRoot());
            System.out.println();
            // Print nodes in breadth-first order
            System.out.println("Breadth-first traversal:");
            bst.printBF();



            /* Heap Testing ----------------------------------------------------------------------------------*/
            //Max Heap Test 


            MaxHeap heap = new MaxHeap();
            heap.Insert(5);
            heap.Insert(10);
            heap.Insert(2);
            heap.Insert(8);
            heap.Print();
            heap.Delete(2);
            heap.Print();
    


             //Min Heap Testing --------------------------------------------------------------------------------

             
             MinHeap heap = new MinHeap();
             heap.Insert(4);
             heap.Insert(2);
             heap.Insert(6);
             heap.Insert(1);
             heap.Insert(5);
             heap.Insert(3);
             heap.Print();
        
             System.out.println("Heap size: " + heap.GetSize());
             System.out.println("Heap contains 5: " + heap.Contains(5));
             System.out.println("Heap contains 7: " + heap.Contains(7));
        
             heap.Delete(3);
             heap.Print();
             heap.Clear();
             heap.Print();
              
             




            /* Graphalgo Testing ------------------------------------------------------------------------------*/
            
            
            //BFS Test    
           

            Graph graph = new Graph(5);
            graph.addEdge(0, 1, 5);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 2);
            graph.addEdge(1, 3, 6);
            graph.addEdge(2, 3, 7);
            graph.addEdge(3, 4, 4);
    
            System.out.print("BFS traversal starting from vertex 0: ");
            BFS.bfs(graph, 0);


          //DFS Test ----------------------------------------------------------------------------------------------
          
            Graph graph = new Graph(5);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 0);
            graph.addEdge(2, 3);
            graph.addEdge(3, 3);
    
            System.out.println("Depth First Traversal (starting from vertex 2):");
            DFS.dfs(graph, 2);

            //Dijkstra Test--------------------------------------------------------------------------------------


            Graph graph = new Graph(5);
            graph.addEdge(0, 1, 9);
            graph.addEdge(0, 2, 6);
            graph.addEdge(0, 3, 5);
            graph.addEdge(0, 4, 3);
            graph.addEdge(2, 1, 2);
            graph.addEdge(2, 3, 4);

            int[] dist = Dijkstra.dijkstra(graph, 0);
            System.out.println(Arrays.toString(dist));
    


        }
}



