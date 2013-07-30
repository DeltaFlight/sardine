package com.github.sardine;

import java.util.HashMap;
import java.util.Map;

import com.github.sardine.model.DefaultFolders;
import com.github.sardine.model.Response;

/**
 * Yandex.Disk default folders
 *
 * @author Alexander Makarov
 */
public class DefaultFolderMapping {
	private final Map<String, String> mapping;

	public DefaultFolderMapping(Response response) {
		DefaultFolders df = response.getPropstat().get(0).getProp().getDefaultFolders();
		mapping = new HashMap<String, String>();
	}

	public String getPath(String id) {
		return mapping.get(id);
	}

}
