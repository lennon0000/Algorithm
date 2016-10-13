package pocketgem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindPath {

	public static void main(String[] args) {

		String fileName = "/Users/Lennon/Desktop/pocketgem/oa1/input_1.txt";
		HashMap nodes = parseToNodes(fileName);

		List<String> paths = findPath(nodes);
		System.out.println(paths);

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
		Node fromNode = (Node) nodes.get(from);
		HashSet<Node> children = fromNode.getChildren();
		itetator(from, to, children, nodes, result);

		return result;
	}

	private static void itetator(String from, String to, HashSet<Node> children, HashMap nodes, List<String> paths) {
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

	public static HashMap parseToNodes(String fileName) {

		HashMap<String, Node> nodes = new HashMap<String, Node>();

		try {
			File file = new File(fileName);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			line = br.readLine();
			String[] firstLine = line.trim().split(" ");
			String from = firstLine[0];
			String to = firstLine[1];
			nodes.put("from", new Node(from));
			nodes.put("to", new Node(to));
			while (line != null) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String start = line.trim().split(":")[0];
				String[] end = line.trim().split(":")[1].split(" ");
				Node tmpNode = nodes.get(start);
				if (tmpNode != null) {
					List<Node> rns = tmpNode.addChildren(end);
					System.out.println(start.trim());
					nodes.put(start.trim(), tmpNode);
					for (int i = 0; i < rns.size(); i++) {
						Node t = rns.get(i);
						System.out.println(t.getName().trim());
						nodes.put(t.getName().trim(), t);
					}
				} else {
					Node node = new Node(start);
					node.addChildren(end);
					nodes.put(start.trim(), node);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return nodes;
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
}
