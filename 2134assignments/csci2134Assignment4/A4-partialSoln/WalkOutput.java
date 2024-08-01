import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WalkOutput {

    /**
     * Given a random walker, store its most recently walked path to a file.
     * If the walker's path contains 0 steps, then the resulting file will be empty.
     * Otherwise, for N steps, there will be N+1 coordinates printed to the file,
     * one per line. Line i and line i+1 encode the i+1'th step beginning
     * at coordinate i and ending at coordinate i+1.
     * @param fname the name of the file in which to write the path
     * @throws IOException if the file could not be open or created writing
     */
    public static void saveWalkToFile(String fname, List<Coordinate> path) throws IOException {
        if (fname.endsWith(".dat")) {
            saveWalkToFile_intStream(fname, path);
        } else {
            saveWalkToFile_coordPairs(fname, path);
        }

    }

    public static void saveWalkToFile_intStream(String fname, List<Coordinate> path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fname);
        writer.print(String.format("%d %d", path.get(0).x, path.get(0).y));
        for (int i = 1; i < path.size(); ++i) {
            writer.print(String.format(" %d %d", path.get(i).x, path.get(i).y));
        }
        writer.close();
    }

    public static void saveWalkToFile_coordPairs(String fname, List<Coordinate> path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fname);
        for (Coordinate coord : path) {
            writer.println(String.format("(%d, %d)", coord.x, coord.y));
        }
        writer.close();
    }

}
