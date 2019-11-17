import edu.princeton.cs.algs4.StdRandom;
// import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean isOpen[];
    private int n;
    private int numberOfisOpen = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be strictly positive");  
        }
        this.n = n;
        isOpen = new boolean[n*n];
        for (int i = 0; i < n*n; ++i) {
            isOpen[i] = false;
        }
    }

    // Converts row/col index into n x n array index.
    private int index(int row, int col) {
        return (row-1)*n + (col-1);
    }

    private boolean validate(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("index must be between 1 and " + n);  
        }
        return true;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        ++numberOfisOpen;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        int i = index(row, col);
        return isOpen[i];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        // temp
        return false;
    }

    // returns the number of open sites
    public int numberOfisOpen() {
        return numberOfisOpen;
    }

    // does the percSystem percolate?
    public boolean percolates() { 
        if (numberOfisOpen >= n/2) {
            return true;
        } else {
            return false;
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = 20;
        Percolation percSystem = new Percolation(n);
        while(!percSystem.percolates()) {
            // Choose row/col randomly and check that it hasn't been opened already.
            int row = StdRandom.uniform(1, n);
            int col = StdRandom.uniform(1, n);
            // Ignore already open sites.
            while (percSystem.isOpen(row, col)) {
                row = StdRandom.uniform(1, n);
                col = StdRandom.uniform(1, n);
            }
            percSystem.open(row, col);  
        }
        
        double percolationThreshold = percSystem.numberOfisOpen()/ ((double) n*n);
        System.out.println(percolationThreshold);
    }
}