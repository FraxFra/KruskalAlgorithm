package ItalianDistance;
import java.io.*;
import java.util.*;
import java.lang.*;

public class UnionFindSet<T>
{
        protected HashMap<T, T> nodes;
        protected HashMap<T, Integer> ranks;

        public UnionFindSet()
        {
                nodes = new HashMap<T, T>();
                ranks = new HashMap<T, Integer>();
        }

        public void makeSet(T x)
        {
                if(nodes.containsKey(x) == false)
                {
                        nodes.put(x, x);
                        ranks.put(x, 0);
                }
                else
                {
                        throw new Error("Node already exist!");
                }
        }

        public void union(T x, T y)
        {
                T a = this.findSet(x);
                T b = this.findSet(y);
                link(a, b);
        }

        public T findSet(T x)
        {
                if(nodes.containsKey(x) == true)
                {
                        if(x != nodes.get(x))
                        {
                                nodes.replace(x, findSet(nodes.get(x)));
                        }
                        return nodes.get(x);
                }
                else
                {
                        throw new Error("Node does not exist!");
                }
        }

        public void link(T x, T y)
        {
                if(nodes.containsKey(x) == true && nodes.containsKey(y) == true)
                {
                        if(ranks.get(x) > ranks.get(y))
                        {
                                nodes.replace(y, x);
                        }
                        else
                        {
                                nodes.replace(x, y);
                                if(ranks.get(x) == ranks.get(y))
                                {
                                        int tmp = ranks.get(y) + 1;
                                        ranks.replace(y, tmp);
                                }
                        }
                }
                else
                {
                        throw new Error("One or multiple nodes don't exist!");
                }
        }

        public String toString()
        {
                String res = "";
                for (T name : nodes.keySet())
                {
                        res = res + "Node " + name + " points to " + nodes.get(name) + ", rank = " + ranks.get(name) + "\n";
                }
                return res;
        }
}
