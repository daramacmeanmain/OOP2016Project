package ie.gmit.sw.client.config;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLParser {
	
	private Parsetor prs;
	
	//Constructor
	public XMLParser(Parsetor prs){
		super();
		this.prs = prs;
	}
	
	public void run() throws Throwable{
		
		//Create DOM tree
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(Parsetor.CONFIG_FILE);
		
		
		Element root = doc.getDocumentElement();//get root
		NodeList children = root.getChildNodes();//get child
		
		//find elements in the tree
		for (int i = 0; i < children.getLength(); i++){
			
			Node next = children.item(i); 
			
			//Parse username attribute
			prs.setUsername(root.getAttribute("username"));
			
			//Parse elements
			if (next instanceof Element){
				
				Element e = (Element) next;
				
				if (e.getNodeName().equals("server-host")){
					prs.setHost(e.getFirstChild().getNodeValue());
				}
				
				else if(e.getNodeName().equals("server-port")){
					prs.setPort(Integer.parseInt(e.getFirstChild().getNodeValue()));
				}
				
				else if(e.getNodeName().equals("download-dir")){
					prs.setDir(e.getFirstChild().getNodeValue());
				}
			}
		}
	}
	
	//Parsetor Get and Set
	public Parsetor getPrs() {
		return prs;
	}

	public void setPrs(Parsetor prs) {
		this.prs = prs;
	}

}
