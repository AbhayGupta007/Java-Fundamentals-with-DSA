package J_30_Graphs_1;

import java.util.HashMap;
// import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class Traversal {
    // My method.
    public static void DFT(int arr[][])
    {
        HashMap<Integer, Boolean> map = new HashMap<>();
        map.put(0, true);
        System.out.print(arr[0][0]+" ");
        helper(arr, 0 , 0, map);
    }
    public static void helper(int arr[][], int i, int j, HashMap<Integer, Boolean>map)
    {
        if(j == arr.length)
        {
            return;
        }
        if(arr[i][j] == 1)
        {
            if(!map.containsKey(j))
            {
                System.out.print(j+" ");
                map.put(j , true);
                helper(arr, j, 0, map);
            }
            else
            {
                helper(arr, i, j+1, map);
            }
        }
        helper(arr, i, j+1, map);
    }
    
    // Coding ninjas method.
    public static void DF_Traversal(int arr[][])
    {
        int flag = 0;
        boolean isvisited[] = new boolean[arr.length] ;
        for(int i = 0; i< arr.length; i++)
        {
            if(!isvisited[i])
            {
                DF_helper(arr, 0, isvisited);
                System.out.println();    
            }
        }
    }
    public static void DF_helper(int arr[][], int currentvertex,boolean isvisited[])
    {
        System.out.print(currentvertex+" ");
        isvisited[currentvertex] = true;
        for(int i = 0; i < arr.length;i++)
        {
            if(arr[currentvertex][i] == 1 && !isvisited[i])
            { 
                DF_helper(arr, i, isvisited);
            }
        }
    }

    public static void BF_Traversal(int arr[][])
	{
		boolean isvisited[] = new boolean[arr.length];
		for(int i = 0; i<arr.length; i++)
		{
			if(!isvisited[i])
			{
				BF_helper(arr, i, isvisited);
                System.out.println();
			}
		}
	}
	public static void BF_helper(int arr[][], int currentvertex, boolean isvisited[])
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(currentvertex);
        isvisited[currentvertex] = true;
        while(!q.isEmpty())
        {
            currentvertex = q.poll();
            System.out.print(currentvertex+" ");
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[currentvertex][i] == 1 && !isvisited[i])
                {
                    q.add(i);
                    isvisited[i] = true;
                }
            }
        }
	}

    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // System.out.print("Enter the number of vertices: ");
        // int n = s.nextInt();
        // System.out.print("Enter the number of edges: ");
        // int e = s.nextInt();
        // int adjmatrix[][] = new int[n][n];
        // for(int i = 0; i< e;)
        // {
        //     System.out.print("Enter the vertices to create "+ (i+1) + " edge: ");
        //     int v1 = s.nextInt();
        //     int v2 = s.nextInt();
        //     if(v1 < n && v2 < n)
        //     {
        //         adjmatrix[v1][v2] = 1;
        //         adjmatrix[v2][v1] = 1;
        //         i++;
        //     }
        //     else
        //     {
        //         System.out.println("Wrong intput enter again.");
        //     }
        // }
        // for(int i =0; i<n;i++)
        // {
        //     for(int j = 0; j<n; j++)
        //     {
        //         System.out.print(adjmatrix[i][j]+"\t");
        //     }
        //     System.out.println();
        // }
        // s.close();
        int arr[][] = {{0,1,1,1,0,0},
                       {1,0,0,0,1,0}, 
                       {1,0,0,0,0,1}, 
                       {1,0,0,0,0,0}, 
                       {0,1,0,0,0,0}, 
                       {0,0,1,0,0,0}};
                       
        int arr1[][] = {{0,1}, {1,0}};
        DF_Traversal(arr);  System.out.println();
        BF_Traversal(arr1);
    }
}