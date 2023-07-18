import java.util.Scanner;

public class Main
{
    static Scanner ob = new Scanner(System.in);
    static int[] isColored;

    static void setOne(int n)
    {
        for(int i=0;i<n;i++)
            isColored[i] = 1;
    }

    static void input(int[][] graph, int n)
    {
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j] = ob.nextInt();
    }

    static void setIsColoredRecursion(int[][] graph, int n, int index) {
        if (index == n){
            return;
        }
        int indexColor, presentColor;
        for(int i=0;i<n;i++)
        {
            if(graph[index][i] != 0)
            {
                indexColor = isColored[index];
                presentColor = isColored[i];
                if(indexColor == presentColor){
                    isColored[i]++;
                }
            }
        }
        setIsColoredRecursion(graph, n, (index+1));
    }

    static void display(int n)
    {
        //Printing
        System.out.print("Printing Colors: ");
        for(int i=0;i<n;i++)
            System.out.print(isColored[i] + " ");
    }

    public static void main(String[] args)
    {
        int num;
        int[][] graph;
        System.out.print("Enter Number of Vertexes in Graph: ");
        num = ob.nextInt();
        graph = new int[num][num];
        isColored = new int[num];
        setOne(num);
        System.out.println("Enter Values of Graph: ");
        input(graph, num);
        setIsColoredRecursion(graph, num, 0);
        display(num);
    }
}