package prog3.arbol.binario.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Utiles {
	
	public static int sumaMaximaVertical(ArbolBinario<Integer> a) {
	    if (a == null) return 0;
	    Map<Integer, Integer> map = new HashMap<>();
	    Stack<ArbolBinario<Integer>> stack = new Stack<>();
	    Stack<Integer> depthStack = new Stack<>();
	    stack.push(a);
	    depthStack.push(0);
	    int maxSum = Integer.MIN_VALUE;
	    while (!stack.isEmpty()) {
	        ArbolBinario<Integer> node = stack.pop();
	        int depth = depthStack.pop();
	        int sum = node.getDato();
	        if (map.containsKey(depth)) {
	            sum += map.get(depth);
	        }
	        map.put(depth, sum);
	        if (node.tieneHijoDerecho()) {
	            stack.push(node.getHijoDerecho());
	            depthStack.push(depth + 1);
	        }
	        if (node.tieneHijoIzquierdo()) {
	            stack.push(node.getHijoIzquierdo());
	            depthStack.push(depth - 1);
	        }
	        if (node.esHoja()) {
	            if (sum > maxSum) {
	                maxSum = sum;
	            }
	        }
	    }
	    return maxSum;
	}


	
	public static int sumaMaximaHorizontal(ArbolBinario<Integer> a) {
	    int maxSum = Integer.MIN_VALUE;
	    Map<Integer, Integer> sumByLevel = new HashMap<>();
	    sumaMaximaHorizontalRec(a, sumByLevel, 0);
	    for (int levelSum : sumByLevel.values()) {
	        if (levelSum > maxSum) {
	            maxSum = levelSum;
	        }
	    }
	    return maxSum;
	}

	private static void sumaMaximaHorizontalRec(ArbolBinario<Integer> a, Map<Integer, Integer> sumByLevel, int level) {
	    if (a == null) {
	        return;
	    }
	    int sum = sumByLevel.getOrDefault(level, 0) + a.getDato();
	    sumByLevel.put(level, sum);
	    sumaMaximaHorizontalRec(a.getHijoIzquierdo(), sumByLevel, level + 1);
	    sumaMaximaHorizontalRec(a.getHijoDerecho(), sumByLevel, level + 1);
	}

	public static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> a){
		ListaGenericaEnlazada<Integer> res = new ListaGenericaEnlazada<Integer>();
		dfs(a,0,0,res);
		return res;
	}
	
	private static void dfs(ArbolBinario<Integer> node, int currentSum, int level, ListaGenericaEnlazada<Integer> sums) {
	    currentSum += node.getDato() * level;
	    if (!node.tieneHijoDerecho()&&!node.tieneHijoIzquierdo()) {
	        sums.agregarFinal(currentSum);
	    } else {
	    	if (node.tieneHijoIzquierdo()) dfs(node.getHijoIzquierdo(), currentSum, level + 1, sums);
	    	if (node.tieneHijoDerecho()) dfs(node.getHijoDerecho(), currentSum, level + 1, sums);
	    }
	}
}
