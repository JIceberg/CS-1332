import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Charlie Jenkins cjenkins72@gatech.edu
 * @version 1.0
 */
public class GraphAlgorithmsCharlieTest {
    @Rule
    public Timeout globalTimeout = new Timeout(200, TimeUnit.MILLISECONDS);

    /*
        Directed down and to the right (- means ->, | means down arrow)
        1 - 11 - 111 - 1111
        |   |     |      |
        2 - 22 - 222 - 2222
        |   |     |      |
        3 - 33 - 333 - 3333
        |   |     |      |
        4 - 44 - 4444 - 4444
        The edges are added in the order of down and then right
        I am too lazy to write all of the weights down in the diagram, you can look at the code
        below if you are interested. They are just "randomly" assigned.
     */
    private Graph<Integer> elongatedGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        int[] items =
                new int[] {1, 2, 3, 4, 11, 22, 33, 44, 111, 222, 333, 444, 1111, 2222, 3333, 4444};
        for (int integer : items) {
            vertices.add(new Vertex<>(integer));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 5));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(11), 2));

        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 3));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(22), 7));

        edges.add(new Edge<>(new Vertex<>(11), new Vertex<>(22), 8));
        edges.add(new Edge<>(new Vertex<>(11), new Vertex<>(111), 8));

        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 7));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(33), 1));

        edges.add(new Edge<>(new Vertex<>(22), new Vertex<>(33), 0));
        edges.add(new Edge<>(new Vertex<>(22), new Vertex<>(222), 5));

        edges.add(new Edge<>(new Vertex<>(111), new Vertex<>(222), 2));
        edges.add(new Edge<>(new Vertex<>(111), new Vertex<>(1111), 3));

        edges.add(new Edge<>(new Vertex<>(111), new Vertex<>(222), 2));
        edges.add(new Edge<>(new Vertex<>(111), new Vertex<>(1111), 35));

        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(44), 5));

        edges.add(new Edge<>(new Vertex<>(33), new Vertex<>(44), 5));
        edges.add(new Edge<>(new Vertex<>(33), new Vertex<>(333), 6));

        edges.add(new Edge<>(new Vertex<>(222), new Vertex<>(333), 3));
        edges.add(new Edge<>(new Vertex<>(222), new Vertex<>(2222), 23));

        edges.add(new Edge<>(new Vertex<>(333), new Vertex<>(444), 5));
        edges.add(new Edge<>(new Vertex<>(333), new Vertex<>(3333), 4));

        edges.add(new Edge<>(new Vertex<>(1111), new Vertex<>(2222), 3));

        edges.add(new Edge<>(new Vertex<>(44), new Vertex<>(444), 3));

        edges.add(new Edge<>(new Vertex<>(333), new Vertex<>(444), 2));
        edges.add(new Edge<>(new Vertex<>(333), new Vertex<>(3333), 1));

        edges.add(new Edge<>(new Vertex<>(2222), new Vertex<>(3333), 0));

        edges.add(new Edge<>(new Vertex<>(444), new Vertex<>(4444), 9));

        edges.add(new Edge<>(new Vertex<>(3333), new Vertex<>(4444), 3));

        return new Graph<>(vertices, edges);
    }

    @Test
    public void elongatedBfs() {
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.bfs(
                new Vertex<>(1), elongatedGraph());

        List<Vertex<Integer>> bfsExpected =
                createVertices(1, 2, 11, 3, 22, 111, 4, 33, 222, 1111, 44, 333, 2222, 444, 3333, 4444);

        assertEquals(bfsExpected, bfsActual);
    }

    @Test
    public void elongatedDfs() {
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.dfs(
                new Vertex<>(1), elongatedGraph());

        List<Vertex<Integer>> dfsExpected =
                createVertices(1, 2, 3, 4, 44, 444, 4444, 33, 333, 3333, 22, 222, 2222, 11, 111, 1111);

        assertEquals(dfsExpected, dfsActual);
    }

    /**
     * Interesting information. In Aubrey's test, they used Map.of() method, I tried to
     * use it and got an error! I looked at the source code and saw that the method is just
     * overloaded a whole bunch of times so you can only use that function to create a map of at
     * most length 10. I took the easy route and just split it up into two calls to that build
     * method. {@link java.util.Map#of()}
     */
    @Test
    public void dijkstras() {
        Map<Vertex<Integer>, Integer> dijkstras =
                GraphAlgorithms.dijkstras(new Vertex<>(1), elongatedGraph());
        Map<Vertex<Integer>, Integer> expected = new HashMap<>(Map.of(
                new Vertex<>(1), 0,
                new Vertex<>(33), 9,
                new Vertex<>(2), 5,
                new Vertex<>(3), 8,
                new Vertex<>(4), 15,
                new Vertex<>(3333), 16,
                new Vertex<>(11), 2,
                new Vertex<>(44), 14,
                new Vertex<>(2222), 16,
                new Vertex<>(111), 10
        ));

        expected.putAll(
                Map.of(
                        new Vertex<>(22), 10,
                        new Vertex<>(1111), 13,
                        new Vertex<>(444), 17,
                        new Vertex<>(4444), 19,
                        new Vertex<>(333), 15,
                        new Vertex<>(222), 12
                )
        );

        assertEquals(expected, dijkstras);
    }

    @Test
    public void testKruskals() {
        Set<Edge<Integer>> kruskals = GraphAlgorithms.kruskals(elongatedGraph());
        Set<Edge<Integer>> expected = new HashSet<>(List.of(
                new Edge<>(new Vertex<>(2), new Vertex<>(3), 3),
                new Edge<>(new Vertex<>(3), new Vertex<>(2), 3),
                new Edge<>(new Vertex<>(1), new Vertex<>(2), 5),
                new Edge<>(new Vertex<>(2), new Vertex<>(1), 5),
                new Edge<>(new Vertex<>(1), new Vertex<>(11), 2),
                new Edge<>(new Vertex<>(11), new Vertex<>(1), 2),
                new Edge<>(new Vertex<>(333), new Vertex<>(3333), 1),
                new Edge<>(new Vertex<>(3333), new Vertex<>(333), 1),
                new Edge<>(new Vertex<>(22), new Vertex<>(222), 5),
                new Edge<>(new Vertex<>(222), new Vertex<>(22), 5),
                new Edge<>(new Vertex<>(222), new Vertex<>(333), 3),
                new Edge<>(new Vertex<>(333), new Vertex<>(222), 3),
                new Edge<>(new Vertex<>(44), new Vertex<>(444), 3),
                new Edge<>(new Vertex<>(444), new Vertex<>(44), 3),
                new Edge<>(new Vertex<>(3333), new Vertex<>(4444), 3),
                new Edge<>(new Vertex<>(4444), new Vertex<>(3333), 3),
                new Edge<>(new Vertex<>(3), new Vertex<>(33), 1),
                new Edge<>(new Vertex<>(33), new Vertex<>(3), 1),
                new Edge<>(new Vertex<>(2222), new Vertex<>(3333), 0),
                new Edge<>(new Vertex<>(3333), new Vertex<>(2222), 0),
                new Edge<>(new Vertex<>(4), new Vertex<>(44), 5),
                new Edge<>(new Vertex<>(44), new Vertex<>(4), 5),
                new Edge<>(new Vertex<>(111), new Vertex<>(222), 2),
                new Edge<>(new Vertex<>(222), new Vertex<>(111), 2),
                new Edge<>(new Vertex<>(333), new Vertex<>(444), 2),
                new Edge<>(new Vertex<>(444), new Vertex<>(333), 2),
                new Edge<>(new Vertex<>(22), new Vertex<>(33), 0),
                new Edge<>(new Vertex<>(33), new Vertex<>(22), 0),
                new Edge<>(new Vertex<>(111), new Vertex<>(1111), 3),
                new Edge<>(new Vertex<>(1111), new Vertex<>(111), 3)
        ));
        assertEquals(kruskals, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bfsNullStart() {
        GraphAlgorithms.bfs(null, elongatedGraph());
    }

    @Test(expected = IllegalArgumentException.class)
    public void bfsNullGraph() {
        GraphAlgorithms.bfs(new Vertex<>(1), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bfsNullGraphAndEdge() {
        GraphAlgorithms.bfs(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bfsStartNotInGraph() {
        GraphAlgorithms.bfs(new Vertex<>(-1), elongatedGraph());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dfsNullStart() {
        GraphAlgorithms.dfs(null, elongatedGraph());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dfsNullGraph() {
        GraphAlgorithms.dfs(new Vertex<>(1), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dfsNullGraphAndEdge() {
        GraphAlgorithms.dfs(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dfsStartNotInGraph() {
        GraphAlgorithms.dfs(new Vertex<>(-1), elongatedGraph());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dijkstrasNullStart() {
        GraphAlgorithms.dijkstras(null, elongatedGraph());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dijkstrasNullGraph() {
        GraphAlgorithms.dijkstras(new Vertex<>(1), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dijkstrasNullGraphAndEdge() {
        GraphAlgorithms.dijkstras(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dijkstrasStartNotInGraph() {
        GraphAlgorithms.dijkstras(new Vertex<>(-1), elongatedGraph());
    }

    @Test(expected = IllegalArgumentException.class)
    public void kruskalsNullGraph() {
        GraphAlgorithms.kruskals(null);
    }

    /**
     * This is just a reminder to run checkstyle!
     * You can just comment this out xD
     */
    /**
    @Test
    public void runCheckstyle() {
        fail("This is a reminder to run checkstyle!");
    }
     */

    private List<Vertex<Integer>> createVertices(int... vertices) {
        List<Vertex<Integer>> vertices1 = new ArrayList<>(vertices.length);
        for (int vertex : vertices) {
            vertices1.add(new Vertex<>(vertex));
        }
        return vertices1;
    }
}