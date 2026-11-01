import java.util.*;

public class TowerOfHanoi {

    static class State {
        String[] rod = new String[3];

        State(String a, String b, String c) {
            rod[0] = a;
            rod[1] = b;
            rod[2] = c;
        }

        String key() {
            return rod[0] + "|" + rod[1] + "|" + rod[2];
        }
    }

    static void print(State s) {
        System.out.println("A: " + s.rod[0]);
        System.out.println("B: " + s.rod[1]);
        System.out.println("C: " + s.rod[2]);
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        // 1 is the smallest disk, n is the largest
        StringBuilder disks = new StringBuilder();

        for (int i = 1; i <= n; i++)
            disks.append(i);

        State start = new State(disks.toString(), "", "");
        State goal = new State("", "", disks.toString());

        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, State> parent = new HashMap<>();

        queue.add(start);
        visited.add(start.key());

        while (!queue.isEmpty()) {

            State current = queue.poll();

            // Goal reached
            if (current.key().equals(goal.key())) {

                ArrayList<State> path = new ArrayList<>();

                while (current != null) {
                    path.add(current);
                    current = parent.get(current.key());
                }

                Collections.reverse(path);

                System.out.println("\nSolution:");

                for (State s : path)
                    print(s);

                System.out.println("Total moves: " + (path.size() - 1));

                sc.close();
                return;
            }

            // Try every possible move
            for (int from = 0; from < 3; from++) {

                if (current.rod[from].isEmpty())
                    continue;

                for (int to = 0; to < 3; to++) {

                    if (from == to)
                        continue;

                    // Top disk of source
                    char disk = current.rod[from].charAt(0);

                    // Check if move is valid
                    if (!current.rod[to].isEmpty()) {

                        char top = current.rod[to].charAt(0);

                        // Larger disk cannot go on smaller disk
                        if (disk > top)
                            continue;
                    }

                    String[] r = current.rod.clone();

                    // Remove disk from source
                    r[from] = r[from].substring(1);

                    // Put disk on destination
                    r[to] = disk + r[to];

                    State next = new State(r[0], r[1], r[2]);

                    if (!visited.contains(next.key())) {

                        visited.add(next.key());
                        parent.put(next.key(), current);
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println("No solution.");

        sc.close();
    }
}