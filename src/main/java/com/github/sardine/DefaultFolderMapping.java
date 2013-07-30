package com.github.sardine;

import java.util.HashMap;
import java.util.Map;

import com.github.sardine.model.DefaultFolders;
import com.github.sardine.model.Response;
import org.w3c.dom.Element;

/**
 * Yandex.Disk default folders
 *
 * @author Alexander Makarov
 */
public class DefaultFolderMapping {
	private final Map<String, String> mapping;

	public DefaultFolderMapping(Response response) {
		DefaultFolders df = response.getPropstat().get(0).getProp().getDefaultFolders();
		mapping = new HashMap<String, String>(df.getAny().size());
		for (Element el : df.getAny()) {
			mapping.put(el.getNodeName(), el.getTextContent());
		}
	}

	public String getPath(String id) {
		return mapping.get(id);
	}

}
