import java.util.*;

public class LocalBeamTSP {

    static int n = 5;

    // Distance between cities
    static int[][] dist = {
        {0, 10, 15, 20, 25},
        {10, 0, 35, 25, 30},
        {15, 35, 0, 30, 20},
        {20, 25, 30, 0, 15},
        {25, 30, 20, 15, 0}
    };

    // Calculate total distance of a route
    static int cost(int[] route) {
        int total = 0;

        for (int i = 0; i < n - 1; i++)
            total += dist[route[i]][route[i + 1]];

        total += dist[route[n - 1]][route[0]];

        return total;
    }

    // Create a new route by swapping two cities
    static int[] neighbor(int[] route, int i, int j) {
        int[] r = route.clone();

        int temp = r[i];
        r[i] = r[j];
        r[j] = temp;

        return r;
    }

    public static void main(String[] args) {

        int k = 3; // Number of beam states

        List<int[]> states = new ArrayList<>();

        // Create initial routes
        for (int i = 0; i < k; i++) {
            int[] route = {0, 1, 2, 3, 4};

            // Shuffle cities except first city
            Random random = new Random(i);

            for (int j = n - 1; j > 1; j--) {
                int x = 1 + random.nextInt(j);
                int temp = route[j];
                route[j] = route[x];
                route[x] = temp;
            }

            states.add(route);
        }

        // Local Beam Search
        for (int step = 0; step < 10; step++) {

            List<int[]> candidates = new ArrayList<>();

            for (int[] route : states) {

                candidates.add(route);

                for (int i = 1; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        candidates.add(neighbor(route, i, j));
                    }
                }
            }

            // Sort routes by cost
            candidates.sort(Comparator.comparingInt(LocalBeamTSP::cost));

            // Keep best k routes
            states = new ArrayList<>();

            for (int i = 0; i < k && i < candidates.size(); i++)
                states.add(candidates.get(i));
        }

        // Best route
        int[] best = states.get(0);

        System.out.println("Best Route:");

        for (int city : best)
            System.out.print((char)('A' + city) + " -> ");

        System.out.println("A");

        System.out.println("Minimum Distance: " + cost(best));
    }
}