import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BreadCrumbWalker extends RandomWalker {

    public BreadCrumbWalker(MarkovChain chain) {
        super(chain);
    }

    @Override
    public List<Coordinate> walk(int Nsteps) {
        if (Nsteps < 1) {
            return new ArrayList<>();
        }

        List<Coordinate> path = super.walk(Nsteps);
        List<Coordinate> reversedPath = new ArrayList<>(path);
        reversedPath.remove(reversedPath.size() - 1);
        Collections.reverse(reversedPath);
        path.addAll(reversedPath);
        return path;
    }
}
