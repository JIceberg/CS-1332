import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GraphAlgorithmsAubreyTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        assertTrue(outContent.toString().isEmpty());
    }

    /**
     *    A - B
     *    | /
     *    C - E
     *    |
     *    D
     *  <a>https://gatech.instructure.com/courses/141902/pages/breadth-first-search-example-1?module_item_id=1048714</a>
     */
    @Test
    public void testBfsExampleOne() {
        Vertex<Character> start = new Vertex<>('A');
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 0}, {'B', 'A', 0},
                {'B', 'C', 0}, {'C', 'B', 0},
                {'C', 'D', 0}, {'D', 'C', 0},
                {'C', 'E', 0}, {'E', 'C', 0},
                {'A', 'C', 0}, {'C', 'A', 0}
        }));
        List<Vertex<Character>> expected = listOfVertices('A', 'B', 'C', 'D', 'E');

        List<Vertex<Character>> actual = GraphAlgorithms.bfs(start, graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**
     *         B -- C -- D
     *        /|   / \   | \
     *      A  |  I   \  |  E
     *        \| / \   \ | /
     *         H -- G -- F
     *  <a>https://gatech.instructure.com/courses/141902/pages/breadth-first-search-example-2?module_item_id=1048716</a>
     */
    @Test
    public void testBfsExampleTwo() {
        Vertex<Character> start = new Vertex<>('A');
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E'),
                new Vertex<>('F'),
                new Vertex<>('H'),
                new Vertex<>('I'),
                new Vertex<>('G')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 0}, {'B', 'A', 0},
                {'A', 'H', 0}, {'H', 'A', 0},
                {'B', 'C', 0}, {'C', 'B', 0},
                {'G', 'H', 0}, {'H', 'G', 0},
                {'H', 'I', 0}, {'I', 'H', 0},
                {'C', 'D', 0}, {'D', 'C', 0},
                {'C', 'F', 0}, {'F', 'C', 0},
                {'D', 'E', 0}, {'E', 'D', 0},
                {'E', 'F', 0}, {'F', 'E', 0},
                {'F', 'G', 0}, {'G', 'F', 0},
                {'I', 'G', 0}, {'G', 'I', 0},
                {'F', 'D', 0}, {'D', 'F', 0},
                {'B', 'H', 0}, {'H', 'B', 0},
                {'I', 'C', 0}, {'C', 'I', 0},
        }));
        List<Vertex<Character>> expected = listOfVertices('A', 'B', 'H', 'C', 'G', 'I', 'D', 'F', 'E');

        List<Vertex<Character>> actual = GraphAlgorithms.bfs(start, graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**
     *    A - B
     *    | /
     *    C - E
     *    |
     *    D
     *    <a>https://gatech.instructure.com/courses/141902/pages/depth-first-search-example-1?module_item_id=1048710</a>
     */
    @Test
    public void testDfsExampleOne() {
        Vertex<Character> start = new Vertex<>('A');
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 0}, {'B', 'A', 0},
                {'B', 'C', 0}, {'C', 'B', 0},
                {'C', 'D', 0}, {'D', 'C', 0},
                {'C', 'E', 0}, {'E', 'C', 0},
                {'A', 'C', 0}, {'C', 'A', 0}
        }));
        List<Vertex<Character>> expected = listOfVertices('A', 'B', 'C', 'D', 'E');

        List<Vertex<Character>> actual = GraphAlgorithms.dfs(start, graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**
     *         B -- C -- D
     *        /|   / \   | \
     *      A  |  I   \  |  E
     *        \| / \   \ | /
     *         J -- H -- F
     *  <a>https://gatech.instructure.com/courses/141902/pages/depth-first-search-example-2?module_item_id=1048712</a>
     */
    @Test
    public void testDfsExampleTwo() {
        Vertex<Character> start = new Vertex<>('A');
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E'),
                new Vertex<>('F'),
                new Vertex<>('H'),
                new Vertex<>('I'),
                new Vertex<>('J')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 0}, {'B', 'A', 0},
                {'B', 'C', 0}, {'C', 'B', 0},
                {'C', 'D', 0}, {'D', 'C', 0},
                {'D', 'E', 0}, {'E', 'D', 0},
                {'E', 'F', 0}, {'F', 'E', 0},
                {'F', 'H', 0}, {'H', 'F', 0},
                {'H', 'I', 0}, {'I', 'H', 0},
                {'I', 'J', 0}, {'J', 'I', 0},
                {'F', 'D', 0}, {'D', 'F', 0},
                {'A', 'J', 0}, {'J', 'A', 0},
                {'B', 'J', 0}, {'J', 'B', 0},
                {'I', 'C', 0}, {'C', 'I', 0},
                {'J', 'H', 0}, {'H', 'J', 0},
                {'C', 'F', 0}, {'F', 'C', 0},
        }));
        List<Vertex<Character>> expected = listOfVertices('A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J');

        List<Vertex<Character>> actual = GraphAlgorithms.dfs(start, graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**       1
     *      A - B
     *    3 | / 1
     *      C
     *    0 | \ 4
     *      D - E
     *        4
     *   <a>https://gatech.instructure.com/courses/141902/pages/dijkstras-algorithm-example-1?module_item_id=1048722</a>
     */
    @Test
    public void testDijkstrasExampleOne() {
        Vertex<Character> start = new Vertex<>('A');
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 1}, {'B', 'A', 1},
                {'B', 'C', 1}, {'C', 'B', 1},
                {'C', 'D', 0}, {'D', 'C', 0},
                {'C', 'E', 4}, {'E', 'C', 4},
                {'A', 'C', 3}, {'C', 'A', 3},
                {'D', 'E', 4}, {'E', 'D', 4}
        }));
        Map<Vertex<Character>, Integer> expected = Map.of(
                new Vertex<>('A'), 0,
                new Vertex<>('B'), 1,
                new Vertex<>('C'), 2,
                new Vertex<>('D'), 2,
                new Vertex<>('E'), 6
        );

        Map<Vertex<Character>, Integer> actual = GraphAlgorithms.dijkstras(start, graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**
     *          B
     *     -1 /   \ -4
     *      A       D
     *     -2 \   / -8
     *          C
     *   <a>https://gatech.instructure.com/courses/141902/pages/dijkstras-algorithm-example-2?module_item_id=1048724</a>
     */
    @Test
    public void testDijkstrasExampleTwo() {
        Vertex<Character> start = new Vertex<>('A');
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', -1},
                {'A', 'C', -2},
                {'B', 'D', -4},
                {'C', 'D', -8},
        }));
        Map<Vertex<Character>, Integer> expected = Map.of(
                new Vertex<>('A'), 0,
                new Vertex<>('B'), -1,
                new Vertex<>('C'), -2,
                new Vertex<>('D'), -10
        );

        Map<Vertex<Character>, Integer> actual = GraphAlgorithms.dijkstras(start, graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**          8    7
     *         B -- C -- D
     *      4 /|11 /2\   | \ 9
     *      A  |  I   \4 |14E
     *      8 \|7/ \6  \ | / 10
     *         H -- G -- F
     *           1     2
     *  <a>https://gatech.instructure.com/courses/141902/pages/dijkstras-algorithm-example-3?module_item_id=1048726</a>
     */
    @Test
    public void testDijkstrasExampleThree() {
        Vertex<Character> start = new Vertex<>('A');
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E'),
                new Vertex<>('F'),
                new Vertex<>('H'),
                new Vertex<>('I'),
                new Vertex<>('G')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 4}, {'B', 'A', 4},
                {'A', 'H', 8}, {'H', 'A', 8},
                {'B', 'C', 8}, {'C', 'B', 8},
                {'G', 'H', 1}, {'H', 'G', 1},
                {'H', 'I', 7}, {'I', 'H', 7},
                {'C', 'D', 7}, {'D', 'C', 7},
                {'C', 'F', 4}, {'F', 'C', 4},
                {'D', 'E', 9}, {'E', 'D', 9},
                {'E', 'F', 10}, {'F', 'E', 10},
                {'F', 'G', 2}, {'G', 'F', 2},
                {'I', 'G', 6}, {'G', 'I', 6},
                {'F', 'D', 14}, {'D', 'F', 14},
                {'B', 'H', 11}, {'H', 'B', 11},
                {'I', 'C', 2}, {'C', 'I', 2},
        }));
        Map<Vertex<Character>, Integer> expected = Map.of(
                new Vertex<>('A'), 0,
                new Vertex<>('B'), 4,
                new Vertex<>('C'), 12,
                new Vertex<>('D'), 19,
                new Vertex<>('E'), 21,
                new Vertex<>('F'), 11,
                new Vertex<>('G'), 9,
                new Vertex<>('H'), 8,
                new Vertex<>('I'), 14
        );

        Map<Vertex<Character>, Integer> actual = GraphAlgorithms.dijkstras(start, graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**          8    7
     *         B -- C -- D
     *      4 /|11 /2\   | \ 9
     *      A  |  I   \4 |14E
     *      8 \|7/ \6  \ | / 10
     *         H -- G -- F
     *           1     2
     *             3
     *           X -- Y
     *  <a>https://gatech.instructure.com/courses/141902/pages/kruskals-algorithm-example-1?module_item_id=1048750</a>
     */
    @Test
    public void testKruskalsExampleOne() {
        Graph<Character> graph = createGraph(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E'),
                new Vertex<>('F'),
                new Vertex<>('H'),
                new Vertex<>('I'),
                new Vertex<>('G'),
                new Vertex<>('X'),
                new Vertex<>('Y')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 4}, {'B', 'A', 4},
                {'A', 'H', 8}, {'H', 'A', 8},
                {'B', 'C', 8}, {'C', 'B', 8},
                {'G', 'H', 1}, {'H', 'G', 1},
                {'H', 'I', 7}, {'I', 'H', 7},
                {'C', 'D', 7}, {'D', 'C', 7},
                {'C', 'F', 4}, {'F', 'C', 4},
                {'D', 'E', 9}, {'E', 'D', 9},
                {'E', 'F', 10}, {'F', 'E', 10},
                {'F', 'G', 2}, {'G', 'F', 2},
                {'I', 'G', 6}, {'G', 'I', 6},
                {'F', 'D', 14}, {'D', 'F', 14},
                {'B', 'H', 11}, {'H', 'B', 11},
                {'I', 'C', 2}, {'C', 'I', 2},
                {'X', 'Y', 3}, {'Y', 'X', 3}
        }));
        Set<Edge<Character>> expected = null;

        Set<Edge<Character>> actual = GraphAlgorithms.kruskals(graph);

        assertThat(actual, is(equalTo(expected)));
    }

    /**       6      3
     *      A -- B -------- D
     *      |\7     4     / |
     *    5 | C ---------   | 16
     *      |  \2           |
     *      E -- F      --- J
     *      | 1  | \5 8/  / |
     *    8 |  10|  I  --   | 11
     *      |    |6//   9   |
     *      G -- H -------- K
     *        14    10
     *    <a>https://gatech.instructure.com/courses/141902/pages/kruskals-algorithm-example-2?module_item_id=1048752</a>
     */
    @Test
    public void testKruskalsExampleTwo() {
        Graph<Character> graph = new Graph<>(Stream.of(
                new Vertex<>('A'),
                new Vertex<>('B'),
                new Vertex<>('C'),
                new Vertex<>('D'),
                new Vertex<>('E'),
                new Vertex<>('F'),
                new Vertex<>('G'),
                new Vertex<>('H'),
                new Vertex<>('I'),
                new Vertex<>('J'),
                new Vertex<>('K')
        ).collect(Collectors.toSet()), interpolateEdges(new Object[][]{
                {'A', 'B', 6}, {'B', 'A', 6},
                {'B', 'D', 3}, {'D', 'B', 3},
                {'A', 'C', 7}, {'C', 'A', 7},
                {'C', 'D', 4}, {'D', 'C', 4},
                {'A', 'E', 5}, {'E', 'A', 5},
                {'C', 'F', 2}, {'F', 'C', 2},
                {'E', 'F', 1}, {'F', 'E', 1},
                {'E', 'G', 8}, {'G', 'E', 8},
                {'G', 'H', 14}, {'H', 'G', 14},
                {'F', 'H', 10}, {'H', 'F', 10},
                {'H', 'I', 6}, {'I', 'H', 6},
                {'F', 'I', 5}, {'I', 'F', 5},
                {'I', 'J', 8}, {'J', 'I', 8},
                {'H', 'J', 9}, {'J', 'H', 9},
                {'D', 'J', 16}, {'J', 'D', 16},
                {'J', 'K', 11}, {'K', 'J', 11},
                {'H', 'K', 10}, {'K', 'H', 10}
        }));
        Set<Edge<Character>> expected = interpolateEdges(new Object[][]{
                {'F', 'E', 1}, {'E', 'F', 1},
                {'C', 'F', 2}, {'F', 'C', 2},
                {'B', 'D', 3}, {'D', 'B', 3},
                {'C', 'D', 4}, {'D', 'C', 4},
                {'A', 'E', 5}, {'E', 'A', 5},
                {'F', 'I', 5}, {'I', 'F', 5},
                {'H', 'I', 6}, {'I', 'H', 6},
                {'I', 'J', 8}, {'J', 'I', 8},
                {'E', 'G', 8}, {'G', 'E', 8},
                {'H', 'K', 10}, {'K', 'H', 10}
        });

        Set<Edge<Character>> actual = GraphAlgorithms.kruskals(graph);

        assertThat(actual, is(equalTo(expected)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBfsThrowsIllegalArgumentExceptionForNullStart() {
        GraphAlgorithms.bfs(null, new Graph<>(new HashSet<>(), new HashSet<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBfsThrowsIllegalArgumentExceptionForNullGraph() {
        GraphAlgorithms.bfs(new Vertex<>(""), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBfsThrowsIllegalArgumentExceptionForNonExistentStart() {
        GraphAlgorithms.bfs(new Vertex<>('X'), new Graph<>(new HashSet<>(), new HashSet<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDfsThrowsIllegalArgumentExceptionForNullStart() {
        GraphAlgorithms.dfs(null, new Graph<>(new HashSet<>(), new HashSet<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDfsThrowsIllegalArgumentExceptionForNullGraph() {
        GraphAlgorithms.dfs(new Vertex<>(""), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDfsThrowsIllegalArgumentExceptionForNonExistentStart() {
        GraphAlgorithms.dfs(new Vertex<>('X'), new Graph<>(new HashSet<>(), new HashSet<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDijkstrasThrowsIllegalArgumentExceptionForNullStart() {
        GraphAlgorithms.dijkstras(null, new Graph<>(new HashSet<>(), new HashSet<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDijkstrasThrowsIllegalArgumentExceptionForNullGraph() {
        GraphAlgorithms.dijkstras(new Vertex<>(""), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDijkstrasThrowsIllegalArgumentExceptionForNonExistentStart() {
        GraphAlgorithms.dijkstras(new Vertex<>('X'), new Graph<>(new HashSet<>(), new HashSet<>()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKruskalsThrowsIllegalArgumentExceptionForNullGraph() {
        GraphAlgorithms.kruskals(null);
    }

    /**
     *
     * @param vertices vertices
     * @param edges edges
     * @return graph from inputs
     */
    private Graph<Character> createGraph(Set<Vertex<Character>> vertices, Set<Edge<Character>> edges) {
        return new Graph<>(vertices, edges);
    }

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