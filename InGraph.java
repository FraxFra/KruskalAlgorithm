package ItalianDistance;
import java.util.*;

public interface InGraph<T, E extends Comparable <E>>
{
        public void addNode(T elem);
        public void addEdge(T e1, T e2);
        public boolean direct();
        public boolean containsNode(T elem);
        public boolean containsEdge(T e1, T e2);
        public void deleteNode(T elem);
        public void deleteEdge(T e1, T e2);
        public int getNumberNodes();
        public int getNumberEdges();
        public Object getNodes();
        public List <ArrayList <T>> getEdges();
        public Set <T> getAdjacentNodes(T elem);
        public Graph <T, E> Kruskal();
        public String getInfo();
        public String toString();
}
