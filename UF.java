// Implement Union-Find algorithm.

public class UF {
    

    public UF(int N) {

    }

    public boolean isConnected(int p, int q) {

    }

    public void union(int p, int q) {

    }

    public static void main(String[] args) 
    {
        intN = StdIn.readInt();
        UF uf = new UF(N);

        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.isConnected(p, q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}