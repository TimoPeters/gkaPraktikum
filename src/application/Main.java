package application;

import java.io.IOException;

import org.graphstream.algorithm.Algorithm;
import org.graphstream.algorithm.Dijkstra;
import org.graphstream.algorithm.Dijkstra.Element;
import org.graphstream.algorithm.Kruskal;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import algorithms.BreadthFirstSearch;
import algorithms.Dijkstra2;
import algorithms.Kruaskal;
import algorithms.KruskalSlow;
import algorithms.Prim;
import exceptions.SourceAndTargetEqualsException;
import file_handling.FileControl;
import file_handling.ReadFile;
import file_handling.GraphGenerator;
import file_handling.Reader;
import file_handling.WriteFile;



/**
 * 
 * @author Helge Johannsen, Timo Peters
 *
 */

public class Main {
	public static void main(String args[]) throws IOException, SourceAndTargetEqualsException {

		FileControl fc = new FileControl();
//		fc.readFile("./src/graphDataInput/" , "graph01");
//		fc.writeFile("./src/graphDataOutput/");
		fc.readFile("./src/graphDataOutput/" , "generated1");
//		Graph gen = fc.genGraph(22222,55555, "generated4", true, false);
		Graph gen = fc.getGraph();
       	int kantengewicht = 0;		
		
		
	  	String css = "edge .notintree {size:1px;fill-color:gray;} " +
				 "edge .intree {size:3px;fill-color:black;}";

	  	gen.addAttribute("ui.stylesheet", css);
	 	Kruskal kruskal = new Kruskal("ui.class", "intree", "notintree");

	 	kruskal.init(gen);
	 	kruskal.compute();
		for(Edge e : gen.getEachEdge()){
			//System.out.println(e.getAttribute("ui.class").toString());
			if(e.getAttribute("ui.class").equals("intree")){
				kantengewicht += (int) e.getAttribute("weight");
			}
		}       	
		Algorithm alg = new Kruskal();
       	
       	
		gen.display();
		fc.writeFile("./src/graphDataOutput/", gen);
//		Graph genGraph = gra.generate();
		graphicController.initGraph(gen);



//		fc.writeFile("./src/graphDataOutput/", gen);			
//		System.out.println(kantengewicht);
		
//		System.out.println(KruskalSlow.calcSpanningTree(gen));
//		genGraph.display();
//		Prim.prim(gen, gen.getNode(0));
//		Kruaskal k1 = new Kruaskal(gen);
//		k1.calc();
//		System.out.println(genGraph.getEdge(0).getAttribute("weight").toString());
		
		System.out.println(7+9+13+10+5+6+5+12+9+10+5+5+7);
		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "weight");
		dijkstra.init(gen);
 		dijkstra.setSource(gen.getNode("DWK"));		
 		dijkstra.init(gen);
 		dijkstra.compute();

 		System.out.println(dijkstra.getPath(gen.getNode("EHP")));
 		
	}

}
