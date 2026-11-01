import java.util.*;

public class AStar8Puzzle {

    static int[] goal = {1,2,3,4,5,6,7,8,0};

    static int h(int[] a) {
        int count = 0;

        for (int i = 0; i < 9; i++)
            if (a[i] != 0 && a[i] != goal[i])
                count++;

        return count;
    }

    static void print(int[] a) {
        for (int i = 0; i < 9; i++) {
            System.out.print(a[i] + " ");
            if (i % 3 == 2)
                System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int[] a;
        int g;
        Node parent;

        Node(int[] a, int g, Node parent) {
            this.a = a;
            this.g = g;
            this.parent = parent;
        }

        int f() {
            return g + h(a);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] start = new int[9];

        System.out.println("Enter puzzle (0 for blank):");

        for (int i = 0; i < 9; i++)
            start[i] = sc.nextInt();

        PriorityQueue<Node> pq =
            new PriorityQueue<>((x, y) -> x.f() - y.f());

        pq.add(new Node(start, 0, null));

        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (Arrays.equals(cur.a, goal)) {
                System.out.println("\nSolution:");
                show(cur);
                break;
            }

            String key = Arrays.toString(cur.a);

            if (visited.contains(key))
                continue;

            visited.add(key);

            int zero = 0;

            for (int i = 0; i < 9; i++)
                if (cur.a[i] == 0)
                    zero = i;

            int[] moves = {-3, 3, -1, 1};

            for (int m : moves) {

                int next = zero + m;

                if (next < 0 || next >= 9)
                    continue;

                if (m == -1 && zero % 3 == 0)
                    continue;

                if (m == 1 && zero % 3 == 2)
                    continue;

                int[] b = cur.a.clone();

                b[zero] = b[next];
                b[next] = 0;

                pq.add(new Node(b, cur.g + 1, cur));
            }
        }

        sc.close();
    }

    static void show(Node n) {

        if (n == null)
            return;

        show(n.parent);
        print(n.a);
    }
}