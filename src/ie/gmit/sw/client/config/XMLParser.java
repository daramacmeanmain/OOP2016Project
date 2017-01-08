package ie.gmit.sw.client.config;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLParser {
	
	private Parsetor prs;
	
	public XMLParser(Parsetor prs){
		super();
		this.prs = prs;
	}
	
	public void run() throws Throwable{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(Parsetor.CONFIG_FILE);

		Element root = doc.getDocumentElement(); //Get the root of the node tree
		NodeList children = root.getChildNodes(); //Get the child node of the root
		
		for (int i = 0; i < children.getLength(); i++){
			
			Node next = children.item(i); 
			
			if (next instanceof Element){
				
				Element e = (Element) next;
				
				if (e.getNodeName().equals("client-config")){
					
					NamedNodeMap atts = e.getAttributes();
					
					for (int j = 0; j < atts.getLength(); j++){
						if (atts.item(j).getNodeName().equals("username")){
							prs.setUsername(atts.item(j).getNodeValue());
						}
					}
				}
				
				else if (e.getNodeName().equals("server-host")){
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

	public Parsetor getPrs() {
		return prs;
	}

	public void setPrs(Parsetor prs) {
		this.prs = prs;
	}

}
