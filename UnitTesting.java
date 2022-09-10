import ItalianDistance.*;

public class UnitTesting
{
        public static void main(String[]args)
        {
                Graph<String, Integer> g = new Graph<String, Integer>();

                g.addNode("N1");
                System.out.println("Node N1 added!");
                g.addNode("N2");
                System.out.println("Node N2 added!");
                g.addNode("N3");
                System.out.println("Node N3 added!");
                g.addNode("N4");
                System.out.println("Node N4 added!");
                g.addNode("N5");
                System.out.println("Node N5 added!");
                g.addNode("N6");
                System.out.println("Node N6 added!");
                g.addNode("N7");
                System.out.println("Node N7 added!");
                System.out.println("\n");

                g.addEdge("N1", "N2", 5);
                System.out.println("Edge from Node N1 to Node N2 with weight 5 added!");
                g.addEdge("N2", "N1", 5);
                System.out.println("Edge from Node N2 to Node N1 with weight 5 added!");
                g.addEdge("N4", "N5", 2);
                System.out.println("Edge from Node N4 to Node N5 with weight 2 added!");
                g.addEdge("N5", "N4", 2);
                System.out.println("Edge from Node N5 to Node N4 with weight 2 added!");
                g.addEdge("N3", "N6", 3);
                System.out.println("Edge from Node N3 to Node N6 with weight 3 added!");
                g.addEdge("N6", "N3", 8);
                System.out.println("Edge from Node N6 to Node N3 with weight 8 added!");
                System.out.println("\n");
                System.out.println(g.toString());

                System.out.println("The graph g is direct: " + g.direct());
                System.out.println("\n");

                System.out.println("Graph contains Node N1: " + g.containsNode("N1"));
                System.out.println("Graph contains Node N7: " + g.containsNode("N7"));
                System.out.println("\n");

                System.out.println("Graph contains Edge N1 to N2: " + g.containsEdge("N1", "N2"));
                System.out.println("Graph contains Edge N2 to N5: " + g.containsEdge("N2", "N5"));
                System.out.println("\n");

                System.out.println("Number of Nodes: " + g.getNumberNodes());
                System.out.println("Number of Edges: " + g.getNumberEdges()+"\n");

                System.out.println("-- Edges stamp --");
                g.getEdges().forEach(System.out::println);

                System.out.println("-- Adjacent Nodes of N3 --");
                g.getAdjacentNodes("N3").forEach(System.out::println);

                g.deleteNode("N1");
                System.out.println("Node N1 deleted\n");

                System.out.println(g.toString());

        }
}
