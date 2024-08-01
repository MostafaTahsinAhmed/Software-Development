import java.util.List;

public interface IWalker {

    /**
     * Perform a random walk of Nsteps and return the resulting path.
     * The path is encoded as a list of coordinates indicating the start and end of
     * each step. Specifically, the coordinate at index i and the coordinate at index i+1
     * encode the i+1'th step from coordinate i to coordinate i+1.
     *
     * If Nsteps is 0 or negative, the resulting path is empty.
     *
     * Note that each call to walk resets the path of this walker to start again from
     * the default starting point and clears the history of the previous path.
     *
     * @param Nsteps: the number of steps to simulate in the random walk
     * @return the path of the walk.
     */
    public List<Coordinate> walk(int Nsteps);

}
