import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GraphAlgorithmsKrishTest {

    private static final int TIMEOUT = 200;

    private Graph<Character> undirectedGraph1;
    private Graph<Character> undirectedGraph2;
    private Graph<Character> directedGraph1;
    private Graph<Character> directedGraph2;


    @Before
    public void initGraph() {

        /*
            d ------ y  k
             \       | /
              \      |/
               m     z
         */
        Set<Vertex<Character>> vertices1 = setOfVertices('d', 'k', 'm', 'y', 'z');
        Set<Edge<Character>> edges1 = interpolateEdges(new Object[][]{
                {'d', 'm', 0}, {'d', 'y', 0}, {'k', 'z', 0}, {'y', 'd', 0},
                {'y', 'z', 0}, {'m', 'd', 0}, {'z', 'k', 0}, {'z', 'y', 0}
        });
        this.undirectedGraph1 = new Graph<>(vertices1, edges1);

        /*
                5   3
              A----B----C
              |  2 |    |
            1 |    F    | 1
              | 6 / \ 3 |
              |  /   \  |
              D---------E
                   7
         */
        Set<Vertex<Character>> vertices2 = setOfVertices('a', 'b', 'c', 'd',
                'e', 'f');
        Set<Edge<Character>> edges2 = interpolateEdges(new Object[][]{
                {'a', 'b', 5}, {'a', 'd', 1}, {'b', 'a', 5}, {'b', 'c', 3},
                {'b', 'f', 2}, {'c', 'b', 3}, {'c', 'e', 1}, {'d', 'a', 1},
                {'d', 'e', 7}, {'d', 'f', 6}, {'e', 'c', 1}, {'e', 'd', 7},
                {'e', 'f', 3}, {'f', 'b', 2}, {'f', 'd', 6}, {'f', 'e', 3}
        });
        this.undirectedGraph2 = new Graph<>(vertices2, edges2);
    }

    @Test(timeout = TIMEOUT)
    public void testDfs1() {
        List<Vertex<Character>> expected = listOfVertices('y', 'd', 'm', 'z', 'k');
        assertEquals(expected,
                GraphAlgorithms.dfs(new Vertex<>('y'), undirectedGraph1));
    }

    @Test(timeout = TIMEOUT)
    public void testDfs2() {
        List<Vertex<Character>> expected = listOfVertices('d', 'a', 'b', 'c',
                'e', 'f');
        assertEquals(expected,
                GraphAlgorithms.dfs(new Vertex<>('d'), undirectedGraph2));
    }

    @Test(timeout = TIMEOUT)
    public void testBfs1() {
        List<Vertex<Character>> expected = listOfVertices('z', 'k', 'y', 'd', 'm');
        assertEquals(expected,
                GraphAlgorithms.bfs(new Vertex<>('z'), undirectedGraph1));
    }

    @Test(timeout = TIMEOUT)
    public void testBfs2() {
        List<Vertex<Character>> expected = listOfVertices('d', 'a', 'e', 'f',
                'b', 'c');
        assertEquals(expected,
                GraphAlgorithms.bfs(new Vertex<>('d'), undirectedGraph2));
    }

    @Test(timeout = TIMEOUT)
    public void testDjikstra1() {


        /*       6     4
              H - - K - - M
          2 / |         /  \ 3
           /  |       /     \
         D  1 |   2 /         L
           \  |   /           |
         5  \ | /             |
             \|/      6       |
              C --------------
         */

        Set<Vertex<Character>> vertices3 = setOfVertices('d', 'h', 'k', 'm',
                'c', 'l');
        Set<Edge<Character>> edges3 = interpolateEdges(new Object[][]{
                {'d', 'h', 2}, {'d', 'c', 5}, {'h', 'c', 1}, {'h', 'k', 6},
                {'c', 'm', 2}, {'c', 'l', 6}, {'k', 'm', 4}, {'m', 'l', 3}
        });
        this.directedGraph1 = new Graph<>(vertices3, edges3);

        Map<Vertex<Character>, Integer> expected = Map.of(
                new Vertex<>('d'), 0,
                new Vertex<>('h'), 2,
                new Vertex<>('k'), 8,
                new Vertex<>('c'), 3,
                new Vertex<>('m'), 5,
                new Vertex<>('l'), 8
        );

        assertEquals(expected,
                GraphAlgorithms.dijkstras(new Vertex<>('d'), directedGraph1));
    }

    @Test(timeout = TIMEOUT)
    public void testDjikstra2() {


        /*          5
            B ------------ C
         3 /                \  8
          /  1     7      2  \
         A ---- D ---- E ---- H
          \                  /
         2 \        4       / 6
            F ------------ G
         */

        Set<Vertex<Character>> vertices4 = setOfVertices('a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h');
        Set<Edge<Character>> edges4 = interpolateEdges(new Object[][]{
                {'a', 'b', 3}, {'b', 'c', 5}, {'c', 'h', 8},
                {'a', 'd', 1}, {'d', 'e', 7}, {'e', 'h', 2},
                {'a', 'f', 2}, {'f', 'g', 4}, {'g', 'h', 6}
        });

        this.directedGraph2 = new Graph<>(vertices4, edges4);

        Map<Vertex<Character>, Integer> expected = Map.of(
                new Vertex<>('a'), 0,
                new Vertex<>('b'), 3,
                new Vertex<>('c'), 8,
                new Vertex<>('d'), 1,
                new Vertex<>('e'), 8,
                new Vertex<>('f'), 2,
                new Vertex<>('g'), 6,
                new Vertex<>('h'), 10
        );

        assertEquals(expected,
                GraphAlgorithms.dijkstras(new Vertex<>('a'), directedGraph2));
    }

    @Test(timeout = TIMEOUT)
    public void testKruskal1() {
        /*            5
                B ---------- C
             2 /|            |\ 9
              / |     11     | \
             A ---------------- F
              \ | 8        6 | /
             3 \|            |/ 7
                D ---------- E
                      4
         */

        Set<Vertex<Character>> vertices = setOfVertices('a', 'b', 'c', 'd',
                'e', 'f');
        Set<Edge<Character>> edges = interpolateEdges(new Object[][]{
                {'a', 'b', 2}, {'b', 'a', 2},
                {'a', 'd', 3}, {'d', 'a', 3},
                {'d', 'e', 4}, {'e', 'd', 4},
                {'b', 'c', 5}, {'c', 'b', 5},
                {'c', 'e', 6}, {'e', 'c', 6},
                {'e', 'f', 7}, {'f', 'e', 7},
                {'b', 'd', 8}, {'d', 'b', 8},
                {'c', 'f', 9}, {'f', 'c', 9},
                {'a', 'f', 11}, {'f', 'a', 11},
        });
        Graph<Character> graph = new Graph<>(vertices, edges);

        Set<Edge<Character>> mstExpected = interpolateEdges(new Object[][]{
                {'a', 'b', 2}, {'b', 'a', 2},
                {'a', 'd', 3}, {'d', 'a', 3},
                {'d', 'e', 4}, {'e', 'd', 4},
                {'b', 'c', 5}, {'c', 'b', 5},
                {'e', 'f', 7}, {'f', 'e', 7},
        });
        assertEquals(mstExpected, GraphAlgorithms.kruskals(graph));
    }


    // example from https://gatech.instructure.com/courses/132344/quizzes/173633
    @Test(timeout = TIMEOUT)
    public void testKruskal2() {
        Set<Edge<Character>> mstExpected = interpolateEdges(new Object[][]{
                {'a', 'd', 1}, {'d', 'a', 1},
                {'c', 'e', 1}, {'e', 'c', 1},
                {'b', 'f', 2}, {'f', 'b', 2},
                {'f', 'e', 3}, {'e', 'f', 3},
                {'a', 'b', 5}, {'b', 'a', 5},
        });

        assertEquals(mstExpected,
                GraphAlgorithms.kruskals(this.undirectedGraph2));
    }

    @Test(timeout = TIMEOUT)
    public void testKruskalDisconnected() {
        /*
                B            C
             2 /|            |\ 9
              / |            | \
             A  |            |  F
              \ | 8        6 | /
             3 \|            |/ 7
                D            E
                      4
         */

        Set<Vertex<Character>> vertices = setOfVertices('a', 'b', 'c', 'd',
                'e', 'f');
        Set<Edge<Character>> edges = interpolateEdges(new Object[][]{
                {'a', 'b', 2}, {'b', 'a', 2},
                {'a', 'd', 3}, {'d', 'a', 3},
                {'c', 'e', 8}, {'e', 'c', 6},
                {'e', 'f', 8}, {'f', 'e', 7},
                {'b', 'd', 8}, {'d', 'b', 8},
                {'c', 'f', 8}, {'f', 'c', 8},
        });
        Graph<Character> graph = new Graph<>(vertices, edges);

        assertNull(GraphAlgorithms.kruskals(graph));
    }

    /**
     * Create a set of vertices with the given characters
     * @param chars characters to add to vertex set
     * @return the set of vertices
     */
    private Set<Vertex<Character>> setOfVertices(char... chars) {
        Set<Vertex<Character>> vertices = new LinkedHashSet<>();
        for (char character : chars) {
            vertices.add(new Vertex<>(character));
        }
        return vertices;
    }

    // The below helper methods are from Aubrey Yan's test file
    // (https://github.gatech.edu/gist/ayan46/c9174199f450f174a5b71ea8e0c5842a)
    /**
     *
     * @param array 2d array representation of edges
     * @return set of edges specified by input array
     */
    private Set<Edge<Character>> interpolateEdges(Object[][] array) {
        Set<Edge<Character>> edges = new LinkedHashSet<>();
        for (Object[] objects : array) {
            edges.add(new Edge<>(new Vertex<>((char) objects[0]), new Vertex<>((char) objects[1]), (int) objects[2]));
        }
        return edges;
    }

    /**
     *
     * @param chars characters
     * @return list of vertices
     */
    private List<Vertex<Character>> listOfVertices(char... chars) {
        List<Vertex<Character>> vertices = new ArrayList<>(chars.length);
        for (char character : chars) {
            vertices.add(new Vertex<>(character));
        }
        return vertices;
    }

}