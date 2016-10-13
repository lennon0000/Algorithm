package pocketgem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class PathFinder {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = "/Users/Lennon/Desktop/pocketgem/oa1/input_1.txt";
		if (args.length > 0) {
			filename = args[0];
		}

		List<String> answer = parseFile(filename);
		System.out.println(answer);
	}

	static List<String> parseFile(String filename) throws FileNotFoundException, IOException {
		/*
		 * Don't modify this function
		 */
		BufferedReader input = new BufferedReader(new FileReader(filename));
		List<String> allLines = new ArrayList<String>();
		String line;
		while ((line = input.readLine()) != null) {
			allLines.add(line);
		}
		input.close();

		return parseLines(allLines);
	}

	static List<String> parseLines(List<String> lines) {

		HashMap<String, Node> nodes = new HashMap<String, Node>();

		String[] firstLine = lines.get(0).trim().split(" ");
		String from = firstLine[0];
		String to = firstLine[1];
		nodes.put("from", new Node(from));
		nodes.put("to", new Node(to));
		String line = "";
		for (int i = 1; i < lines.size(); i++) {
			line = lines.get(i);
			String start = line.trim().split(":")[0];
			String[] end = line.trim().split(":")[1].split(" ");
			Node tmpNode = nodes.get(start);
			if (tmpNode != null) {
				List<Node> rns = tmpNode.addChildren(end);
				System.out.println(start.trim());
				nodes.put(start.trim(), tmpNode);
				for (int j = 0; j < rns.size(); j++) {
					Node t = rns.get(j);
					nodes.put(t.getName().trim(), t);
				}
			} else {
				Node node = new Node(start);
				node.addChildren(end);
				nodes.put(start.trim(), node);
			}
		}

		List<String> paths = findPath(nodes);

		return paths;
	}

	private static List<String> findPath(HashMap<String, Node> nodes) {
		Node f = (Node) nodes.get("from");
		String from = f.getName();
		Node t = (Node) nodes.get("to");
		String to = t.getName();
		List<String> result = new ArrayList<String>();
		if (nodes.get(from) == null) {
			return result;
		}
		if(from.equals(to)){
			result.add(from);
			return result;
		}
		Node fromNode = (Node) nodes.get(from);
		HashSet<Node> children = fromNode.getChildren();
		itetator(from, to, children, nodes, result);

		return result;
	}

	static class Node {
		String name;
		HashSet<Node> children;

		public Node(String string) {
			this.name = string.trim();
			this.children = new HashSet<Node>();
		}

		public List<Node> addChildren(String[] end) {
			List<Node> returnNodes = new ArrayList<Node>();
			for (int i = 1; i < end.length; i++) {
				Node tmp = new Node(end[i].trim());
				this.children.add(tmp);
				returnNodes.add(tmp);
			}
			return returnNodes;
		}

		public String getName() {
			return name;
		}

		public HashSet<Node> getChildren() {
			return children;
		}

	}

	private static void itetator(String from, String to, HashSet<Node> children, HashMap<String, Node> nodes, List<String> paths) {
		String ini = from;
		String path = ini;
		for (Node node : children) {
			if (!path.contains(node.getName())) {
				path += node.getName();
				Node tmp;
				if (node.getName().equals(to)) {
					paths.add(path);
					path = ini;
				} else {
					if (nodes.get(node.getName()) != null) {
						tmp = (Node) nodes.get(node.getName());
						itetator(path, to, tmp.getChildren(), nodes, paths);
					}
				}
				path = ini;
			}
		}
	}
}