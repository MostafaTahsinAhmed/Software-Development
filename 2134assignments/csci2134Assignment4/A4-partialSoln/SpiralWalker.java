import java.util.List;
import java.util.ArrayList;

public class SpiralWalker implements IWalker {

    private enum WalkDirection {
        NORTH, EAST, SOUTH, WEST
    }

    private int STEP_SIZE = 1;

    private WalkDirection nextDir(WalkDirection current) {
        if (current == WalkDirection.NORTH) {
            return WalkDirection.EAST;
        }
        if (current == WalkDirection.EAST) {
            return WalkDirection.SOUTH;
        }
        if (current == WalkDirection.SOUTH) {
            return WalkDirection.WEST;
        }
        return WalkDirection.NORTH;
    }

    @Override
    /**
     * Walk in a clockwise spiral of increasing radius.
     * Clockwise means that it first walks north, then east, then south, then west,
     * before restarting the cycle.
     */
    public List<Coordinate> walk(int Nsteps) {
        Coordinate curPos = new Coordinate(0,0);

        List<Coordinate> path = new ArrayList<>();
        path.add(new Coordinate(curPos.x, curPos.y));

        int steps = 0;
        WalkDirection dir = WalkDirection.NORTH;
        int segmentLength = 1;
        int currentSegementLength = 0;
        while (steps < Nsteps) {
            if (currentSegementLength == segmentLength) {
                dir = nextDir(dir);
                if (dir == WalkDirection.SOUTH || dir == WalkDirection.NORTH) {
                    segmentLength += 1;
                }
                currentSegementLength = 0;
            }

            curPos.accumulate(getStepDirection(dir));
            path.add(new Coordinate(curPos.x, curPos.y));

            ++currentSegementLength;
            ++steps;
        }

        return path;
    }

    private Coordinate getStepDirection(WalkDirection dir) {
        Coordinate step = new Coordinate(0,0);
        if (dir == WalkDirection.NORTH) {
            step.accumulate(new Coordinate(0, STEP_SIZE));
        } else if (dir == WalkDirection.EAST) {
            step.accumulate(new Coordinate(STEP_SIZE, 0));
        } else if (dir == WalkDirection.SOUTH) {
            step.accumulate(new Coordinate(0, -STEP_SIZE));
        } else {
            step.accumulate(new Coordinate(-STEP_SIZE, 0));
        }
        return step;
    }

}
