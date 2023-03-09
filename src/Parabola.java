public class Parabola {
    private int a;
    private int b;
    private int c;
    private int x;
    private int y;
    public Parabola(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x=-b/2*a;
        this.y=(int)(-Math.pow(b,2)+4*a*c)/4*a;
    }
    public double getLungime(Parabola p)
    {
        return Math.hypot((this.x-p.x),(this.y-p.y));
    }

    public static double getLungime(Parabola p1, Parabola p2)
    {
        return Math.hypot((p1.x-p2.x),(p1.y-p2.y));
    }
    public int[] getMid(Parabola p)
    {
        int[] arr = new int[2];
        int x=(this.x+p.getX())/2;
        int y=(this.y)+p.getY()/2;
        arr[0]=x;
        arr[1]=y;
        return arr;
    }
    public static int[] getMid(Parabola p1, Parabola p2)
    {
        int[] arr = new int[2];
        int x=(p1.x+p2.getX())/2;
        int y=(p1.y)+p2.getY()/2;
        arr[0]=x;
        arr[1]=y;
        return arr;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
    @Override
    public String toString()
    {
        return a+"x^2"+" "+b+"x"+" "+c;
    }
}
