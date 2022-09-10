package ItalianDistance;
import java.io.*;
import java.lang.*;
import java.util.*;


public class Graph<T, E extends Comparable<E>>
{
        protected HashMap<T, HashMap<T, E>> nodes;

        public Graph()
        {
                nodes = new HashMap<T, HashMap<T, E>>();
        }

        public void addNode(T elem)
        {
                if(nodes.containsKey(elem) == false)
                {
                        nodes.put(elem, null);
                }
        }

        public void addEdge(T e1, T e2, E weight)
        {
                if(nodes.containsKey(e1) == false)
                {
                        addNode(e1);
                }

                if(nodes.containsKey(e2) == false)
                {
                        addNode(e2);
                }

                HashMap<T, E> tmp = nodes.get(e1);
                if(tmp == null)
                {
                        tmp = new HashMap<T, E>();
                }
                tmp.put(e2, weight);
                nodes.put(e1, tmp);
        }

        public boolean containsNode(T elem)
        {
                return nodes.containsKey(elem);
        }

        public boolean containsEdge(T e1, T e2)
        {
                boolean res = false;
                HashMap<T, E> tmp = nodes.get(e1);
                if(tmp != null)
                {
                        if(tmp.containsKey(e2))
                        {
                                res = true;
                        }
                }
                return res;
        }

        public void deleteEdge(T e1, T e2)
        {
                HashMap<T, E> tmp = nodes.get(e1);
                if(tmp != null)
                {
                        tmp.remove(e2);
                        nodes.replace(e1, tmp);
                }
        }

        public void deleteNode(T elem)
        {
                if(containsNode(elem))
                {
                        for(T n : nodes.keySet())
                        {
                                HashMap<T, E> tmp = nodes.get(n);
                                if(tmp != null)
                                {
                                        if(tmp.containsKey(elem))
                                        {
                                                tmp.remove(elem);
                                                nodes.replace(n, tmp);
                                        }
                                }
                        }
                        nodes.remove(elem);
                }
        }

        public int getNumberNodes()
        {
                return nodes.size();
        }

        public int getNumberEdges()
        {
                int res = 0;
                for(T n : nodes.keySet())
                {
                        HashMap<T, E> tmp = nodes.get(n);
                        if(tmp != null)
                        {
                                res = res + tmp.size();
                        }
                }
                return res;
        }

        public Object getNodes()
        {
                return nodes.keySet();
        }

        public List<Edge <T, E>> getEdges()
        {
                List<Edge<T, E>> res = new ArrayList<Edge<T, E>>();
                for(T n : nodes.keySet())
                {
                        HashMap<T, E> tmp = nodes.get(n);
                        if(tmp != null)
                        {
                                for(T e : tmp.keySet())
                                {
                                        res.add(new Edge<T, E>(n, e, tmp.get(e)));
                                }
                        }
                }
                return res;
        }

        public Set<T> getAdjacentNodes(T elem)
        {
                if(containsNode(elem))
                {
                        HashMap<T, E> tmp = nodes.get(elem);
                        return tmp.keySet();
                }
                else
                {
                        return null;
                }
        }

        public boolean direct()
        {
                boolean res = true;
                for(T n : nodes.keySet())
                {
                        HashMap<T, E> tmp = nodes.get(n);
                        if(tmp != null)
                        {
                                for(T e : tmp.keySet())
                                {
                                        if(nodes.containsKey(e))
                                        {
                                                HashMap<T, E> tmp2 = nodes.get(e);
                                                if(tmp2 != null)
                                                {
                                                        if(tmp2.containsKey(n) == false)
                                                        {
                                                                res = false;
                                                        }
                                                }
                                                else
                                                {
                                                        res = false;
                                                }
                                        }
                                        else
                                        {
                                                res = false;
                                        }
                                }
                        }
                }
                return res;
        }

        public Graph <T, E> Kruskal()
        {
                UnionFindSet<T> x = new UnionFindSet<T>();
                Graph<T, E> minTree = new Graph<T, E>();
                List<Edge<T, E>> l = getEdges();
                Collections.sort(l);

                for(Edge<T, E> e : l)
                {
                        if(!(x.nodes.containsKey(e.a)))
                        {
                                x.makeSet(e.a);
                        }
                        if(!(x.nodes.containsKey(e.b)))
                        {
                                x.makeSet(e.b);
                        }
                }

                for(Edge<T, E> e : l)
                {
                        T u = x.findSet(e.a);
                        T v = x.findSet(e.b);
                        if(!(u.equals(v)))
                        {
                                minTree.addEdge(e.a, e.b, e.weight);
                                x.union(u, v);
                        }
                }
                return minTree;
        }

        public String getInfo()
        {
                Double tot = 0.0;
                if(nodes != null)
                {
                        for(T n : nodes.keySet())
                        {
                                HashMap<T, E> tmp = nodes.get(n);
                                if(tmp != null)
                                {
                                        for(T e : tmp.keySet())
                                        {
                                                tot = tot + (Double)tmp.get(e);
                                        }
                                }
                        }
                }
                return "Number of Nodes: " + getNumberNodes() + " Number of Edges: " + getNumberEdges() + " Total Weight:" + tot + " km";
        }

        public String toString()
        {
                String res = "";
                for(Edge <T,E> e : getEdges())
                {
                        if(e != null)
                        {
                                res = res + e.toString();
                        }
                }
                return res;
        }
}
