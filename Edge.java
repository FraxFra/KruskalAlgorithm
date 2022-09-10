package ItalianDistance;
import java.lang.*;

public class Edge<T, E extends Comparable<E>> implements Comparable <Edge<T, E>>
{
        protected T a;
        protected T b;
        protected E weight;

        public Edge()
        {
                this.a = null;
                this.b = null;
                this.weight = null;
        }

        public Edge(T a, T b, E weight)
        {
                this.a = a;
                this.b = b;
                this.weight = weight;
        }

        public int compareTo(Edge<T, E> o)
        {
                if(o != null)
                {
                        return (this.weight).compareTo(o.weight);
                }
                else
                {
                        throw new Error("Edge null!");
                }
        }

        public String toString()
        {
                return "Node " + a + " points to " + b + ", weight = " + weight + "\n";
        }
}
