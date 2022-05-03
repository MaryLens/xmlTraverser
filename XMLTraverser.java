package xml;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTraverser {

	private Element root;

	public XMLTraverser(Element root) {
		this.root = root;
	}
	public List<Node> getChildren() {
		return getChildren(this.root);
	}
	public List<Node> getChildren(Node parent) {
		
		Stream<Node> stream = null;
		
		//hw1
		 stream = childrenToStream(parent);
				 
		 stream = childrenToStream(stream.collect(Collectors.toList()).get(0));
		
		//return the result of a terminal collecting operation 
		return stream.collect(Collectors.toList());
	}
	
	public Stream<Node> childrenToStream(Node parent){
		return IntStream
				 .range(0,parent.getChildNodes().getLength())
				 .mapToObj(parent.getChildNodes()::item)
				 .filter(parent_->parent_.getNodeType()!= Node.TEXT_NODE);
	}
	
}
